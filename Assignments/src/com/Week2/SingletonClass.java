package com.Week2;

public class SingletonClass {
    static private SingletonClass instance = null;

    private SingletonClass(){
        System.out.println("Private constructor of Singleton Class");
    }

    public static SingletonClass getInstance(){
        if(instance != null)
            throw new RuntimeException("Object of SingletonClass already created");

        instance = new SingletonClass();
        return instance;
    }
}
