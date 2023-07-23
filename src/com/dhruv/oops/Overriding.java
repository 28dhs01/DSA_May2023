package com.dhruv.oops;

public class Overriding {
    public static void main(String[] args) {
        Superclass object = new Superclass();
        object.greet();
        Subclass obj = new Subclass();
        obj.greet();
//        in below one i can run the variables of reference class while actually which run are of type object class itself
        Superclass myObj = new Subclass();
        myObj.greet();
//        gives run time exception
//        reference variable is of child class and object itself is of parent class
//        Subclass sc = new Superclass();
    }
}
class Superclass{
    void greet(){
        System.out.println("hi");
    }
}
class Subclass extends Superclass{
    @Override
    void greet(){
        System.out.println("hello");
    }
}
