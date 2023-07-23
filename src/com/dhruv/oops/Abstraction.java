package com.dhruv.oops;

public class Abstraction {
    public static void main(String[] args) {
        Child1 c = new Child1();
        c.fun(8,4);
        c.myFun();
    }
}
abstract class Parent1{
    int prod ;
    abstract void fun(int p, int q);
    void myFun(){
        System.out.println(prod);
    }
}
class Child1 extends Parent1{

    @Override
    void fun(int p,int q) {
        this.prod = p*q ;
    }
}
