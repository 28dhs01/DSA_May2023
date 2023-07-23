package com.dhruv.dp.basics;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int ans = fib(n);
        System.out.println(ans);

        Scanner sc = new Scanner(System.in) ;

        int[] qb = new int[n+1];
        int answer = memoizedFib(n,qb);
        System.out.println(answer);
    }
    static int fib(int n){
//        base case
        if( n <= 1 ){
            return n ;
        }
//        body
        System.out.println("hello "+n);
        int f = fib(n-1);
        int s = fib(n-2);
        return f+s ;
    }
    static int memoizedFib(int n, int[]qb){
        if( n <= 1 ){
            qb[n] = n ;
            return n ;
        }
        if(qb[n] != 0){
            return qb[n] ;
        }
        System.out.println("hello "+n);
        int f = memoizedFib(n-1,qb);
        int s = memoizedFib(n-2,qb);
        qb[n] = f+s ;
        return qb[n] ;
    }
}
