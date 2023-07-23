package com.dhruv.stack_ds.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MinSwaps {
    public static void main(String[] args) {
        String s = "][][" ;
        int ans = minSwaps(s) ;
        System.out.println(ans);
    }
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>() ;
        for( int i = 0 ; i<s.length() ; i++ ){
            char ch = s.charAt(i) ;
            if( ch == '[' ){
                stack.push(ch) ;
            }else{
                if( !stack.isEmpty() && stack.peek() == '[' ){
                    stack.pop() ;
                }else{
                    stack.push(ch) ;
                }
            }
        }
        System.out.println(stack) ;
        int n = stack.size() ;
        n = n/2 ;
        int [] ar = new int[n+1] ;
        for( int i = 1 ; i<ar.length; i++ ){
            if( i %2 != 0 ){
                ar[i] = i/2 + 1 ;
            }else{
                ar[i] = i/2 ;
            }
        }
        System.out.println(Arrays.toString(ar));
        return ar[n] ;
    }
}
