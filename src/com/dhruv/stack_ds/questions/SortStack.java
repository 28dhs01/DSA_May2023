package com.dhruv.stack_ds.questions;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);
        System.out.println(st);
        sort(st) ;
        System.out.println(st);
    }
    static void sort(Stack<Integer> stack){
//        base case
        if( stack.isEmpty() ){
            return;
        }
//        body
        int peekElement = stack.peek() ;
        stack.pop() ;
        sort(stack);
        insertSorted(stack,peekElement);
    }
    static void insertSorted(Stack<Integer> stack, int element){
//        base case
        if( stack.isEmpty() ){
            stack.push(element);
            return;
        }
//        body
        int peekElement = stack.peek() ;
        if( element > peekElement ){
            stack.push(element) ;
            return;
        }
        stack.pop();
        insertSorted(stack,element);
        stack.push(peekElement);

    }
}
