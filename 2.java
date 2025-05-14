// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class TextInputBuilder{
    StringBuilder sb = new StringBuilder();
    public void add(char c){
        sb.append(c);
    }
    public String getValue(){
        return sb.toString();
    }
}
class NumberInputBuilder extends TextInputBuilder{
    public void add(char c){
        if(c>='0' && c<='9')sb.append(c);
    }
}
class OddInputBuilder extends NumberInputBuilder{
    public void add(char c){
        int ind = c-'0';
        if(c>='0' && c<='9' && ind%2==1)sb.append(c);
    }
}

class Main {
    
    public static void main(String[] args) {
        TextInputBuilder txtBuilder = new TextInputBuilder();
        NumberInputBuilder numBuilder=new NumberInputBuilder();
        OddInputBuilder oddBuilder = new OddInputBuilder();
        txtBuilder.add('s');
        txtBuilder.add('i');
        txtBuilder.add('n');
        txtBuilder.add('g');
        txtBuilder.add('h');
        System.out.println("Text Builder Output : "+txtBuilder.getValue());
        
        numBuilder.add('s');
        numBuilder.add('1');
        numBuilder.add('2');
        numBuilder.add('3');
        numBuilder.add('h');
        System.out.println("Number Builder Output : "+numBuilder.getValue());
        
        oddBuilder.add('s');
        oddBuilder.add('1');
        oddBuilder.add('2');
        oddBuilder.add('3');
        oddBuilder.add('h');
        System.out.println("Odd Builder Output : "+oddBuilder.getValue());
        
    }
}