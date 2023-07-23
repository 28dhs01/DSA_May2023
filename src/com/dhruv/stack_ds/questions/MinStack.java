package com.dhruv.stack_ds.questions;

import java.util.Stack;

public class MinStack {
    Stack<Integer> ns = new Stack<>();
    Stack<Integer> ms = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        if( ns.isEmpty() ){
            ns.push(val);
            ms.push(val);
        }else{
            if( val <= ms.peek() ){
                ms.push(val);
            }
            ns.push(val);
        }
    }

    public void pop() {
        if( ns.peek().equals( ms.peek() ) ) {
            ms.pop();
        }
        ns.pop() ;
    }

    public int top() {
        if( !ns.isEmpty() ){
            return ns.peek();
        }
        return 0 ;
    }

    public int getMin() {
        if( !ms.isEmpty() ){
            return ms.peek();
        }
        return 0 ;
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(512);
        st.push(-1024);
        st.push(-1024);
        st.push(512);
        st.pop();
        int minTillNow = st.getMin() ;
        System.out.println(minTillNow);
        st.pop();
        minTillNow = st.getMin() ;
        System.out.println(minTillNow);
        st.pop();
        minTillNow = st.getMin() ;
        System.out.println(minTillNow);
    }
}
