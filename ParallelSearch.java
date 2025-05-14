import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class Log{
    public static void log(String str){
        System.out.println(str);
    }
}
class ParallelSearch{
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String args[]){
        File dir = new File("");
        if(dir.exists() && dir.isDirectory()){
            
        }
        else {
            Log.log("Invalid Directory Path");
        }    
    }
}

class SearchTasK implements Callable<Void>{
    File file;
    String text;
    public SearchTasK(File file, String search){
        this.file = file;
        this.text = search;
    }
    @Override
    public Void call(){
        Log.log("new executor");
        return null;
    }
}