package com.dhruv.oops;

public class Parent {
    void fun(){
        System.out.println("hi, i am in parent class");
    }
}
class Child extends Parent{
    void funn(){
        System.out.println("i'm in child class");
    }
}
class Main{
    public static void main(String[] args) {
        Child child = new Child();
        child.funn();
        child.fun() ;
        Parent parent = new Parent();
        parent.fun();
//        parent.funn() ; gives run time exception
    }
}
