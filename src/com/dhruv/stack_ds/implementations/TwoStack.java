package com.dhruv.stack_ds.implementations;

import java.util.Stack;

public class TwoStack {
    int[] arr ;
    int size ;
    int top1 ;
    int top2 ;

    public TwoStack() {
        size = 100 ;
        arr = new int[size];
        top1 = -1 ;
        top2 = arr.length ;
    }
    void push1(int x, TwoStack sq)
    {
        if( top2-top1 == 1 ){
            System.out.println("stack is full");
            return;
        }
        top1 ++ ;
        arr[top1] = x ;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        if( top2 - top1 == 1 ){
            System.out.println("stack is full");
            return;
        }
        top2 -- ;
        arr[top2] = x ;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        if( top1 == -1 ){
            System.out.println("stack is empty");
            return -1 ;
        }
        int peekElement = arr[top1];
        top1-- ;
        return peekElement;
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if( top2 == arr.length ){
            System.out.println("stack is empty");
            return -1 ;
        }
        int peekElement = arr[top2];
        top2++ ;
        return peekElement;
    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack();
        ts.push1(10,ts);
        ts.push1(8,ts);
        ts.push1(6,ts);
        ts.push1(12,ts);
        ts.push1(7,ts);
        ts.push1(21,ts);
        ts.push2(15,ts);
        ts.push2(25,ts);
        ts.push2(40,ts);
        ts.push2(9,ts);
        System.out.println(ts.pop1(ts));
        System.out.println(ts.pop2(ts));
    }
}
