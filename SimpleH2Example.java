import java.sql.*;
class SimpleH2Example{

    public static void main(String args[]){
        try{
            Class.forName("org.h2.Driver");
            Connection cn = DriverManager.getConnection("jdbc:h2:mem:testdb", "", "");
            Statement stmt = cn.createStatement();
            stmt.execute("create table students(id int primary key, name varchar)");
            InsertTask task1 = new InsertTask("shubham", 1, stmt);
            task1.start();
            InsertTask task2 = new InsertTask("singh", 2, stmt);
            task2.start();
            task1.join();task2.join();
            PrintUsers(stmt);
            stmt.execute("delete from students where id = 1");
            System.out.println("after delting");
            PrintUsers(stmt);
            stmt.execute("update students set name = 'lol' where id = 2");
            System.out.println("after updating");
            PrintUsers(stmt);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    private static void PrintUsers(Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery("select * from students");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name"));
            }
       }catch(Exception e){System.out.println(e.toString());}
    }
}

class InsertTask extends Thread{
    String name = "";
    int id;
    Statement stmt = null;
    InsertTask(String name, int id, Statement stmt){this.name = name; this.id = id; this.stmt = stmt;}

    public void run(){
        try{
            stmt.execute("insert into students values("+id+",'"+name+"')");
            System.out.println("saving "+name);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
