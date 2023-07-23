package com.dhruv.stack_ds.implementations;

import java.util.Arrays;

public class CustomStack {
    public static void main(String[] args) {
        CustomStack st = new CustomStack();
        st.push(7);
        st.push(4);
        st.push(8);
        st.push(2);
//        System.out.println(st);
        st.pop();
        st.push(22);
//        System.out.println(st);
        st.push(6);
        st.push(18);
        System.out.println(st);
        System.out.println(st.peek());
    }
    private int[] data ;
    private int size ;
    private int ptr ;
    public CustomStack() {
        size = 5 ;
        data = new int[size];
        ptr = -1 ;
    }
    void push(int val){
        if( isFull() ){
            int [] temp = new int[data.length*2];
            for( int i = 0 ; i< data.length ; i++ ){
                temp[i] = data[i];
            }
            size = temp.length;
            data = temp ;
        }
        ptr++ ;
        data[ptr] = val ;
    }
    boolean isFull(){
        return ptr == data.length-1 ;
    }
    int size(){
        return ptr++ ;
    }
    void pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        ptr-- ;
    }
    boolean isEmpty(){
        return ptr==-1 ;
    }
    int peek(){
        if( ptr == -1 ){
            System.out.println("stack is empty");
            return -1 ;
        }
        return data[ptr];
    }

    @Override
    public String toString() {
        int [] arr = new int[ptr+1];
        for( int i = 0 ; i< arr.length ; i++ ){
            arr[i] = data[i];
        }
        return Arrays.toString(arr);
    }
}
