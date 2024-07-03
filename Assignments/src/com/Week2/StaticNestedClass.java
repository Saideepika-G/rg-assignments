package com.Week2;

class StaticNestedClass
{
    static void show()
    {
        System.out.println("super class show method");
    }
    static class StaticMethods
    {
        void show()
        {
            System.out.println("sub class show method");
        }
    }
    public static void main(String[]args)
    {
        StaticNestedClass.show();
        new StaticNestedClass.StaticMethods().show();
    }
}

