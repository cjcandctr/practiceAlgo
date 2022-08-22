package org.leon.designPattern.Factory;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }

    public void saySometing(String words){
        System.out.println(words);
    }
}
