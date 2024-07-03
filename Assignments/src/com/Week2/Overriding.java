package com.Week2;

class Super
{
    int num=20;
    public void display()
    {
        System.out.println("super class method");
    }
}
public class Overriding extends Super
{
    int num;
    public Overriding(int num)
    {
        this.num=num;
    }
    public void display()
    {
        System.out.println("display method");
    }
    public void show()
    {
        this.display();
        display();
        System.out.println(this.num);
        System.out.println(num);
    }
    public static void main(String[]args)
    {
        Overriding o=new Overriding(10);
        o.show();
    }
}

