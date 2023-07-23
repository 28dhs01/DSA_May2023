package com.dhruv.stack_ds.questions;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(25);
        st.push(7);
        st.push(12);
        st.push(21);
        System.out.println(st);

        reverse(st);
        System.out.println(st);
    }
    static void reverse(Stack<Integer> stack){
//        base case
        if(stack.isEmpty()){
            return;
        }
//        body
        int peekElement = stack.peek();
        stack.pop();
        reverse(stack);
        insertAtBottom(stack,peekElement);
    }
    static void insertAtBottom(Stack<Integer>stack,int element){
//        base case
        if( stack.isEmpty() ){
            stack.push(element);
            return;
        }
//        body
        int peekElement = stack.peek();
        stack.pop();
        insertAtBottom(stack,element);
        stack.push(peekElement);

    }
}
