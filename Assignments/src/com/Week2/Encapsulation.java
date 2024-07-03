package com.Week2;

class Student{
    private String name;
    //Dept is made read-only by just having a getter method
    private String dept = "Information Technology";

    Student(String name){
        this.name = name;
    }

    //private member accessed using public method
    public String getName() {
        return name;
    }
    //private member access using public method
    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

}

public class Encapsulation {
    public static void main(String[] args) {
        Student p = new Student("A");
        System.out.println("Name: " + p.getName());
        System.out.println("Department: " + p.getDept());
        p.setName("B");
        System.out.println("Name: " + p.getName());
    }
}
