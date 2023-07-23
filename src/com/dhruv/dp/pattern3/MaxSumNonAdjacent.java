package com.dhruv.dp.pattern3;

import java.util.Scanner;

public class MaxSumNonAdjacent {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int n = scn.nextInt() ;
        int [] arr = new int[n] ;
        for( int i = 0 ; i < n ; i++ ){
            arr[i] = scn.nextInt();
        }
        int oInc = arr[0] ;
        int oExc = 0 ;
        for( int i = 1 ; i<arr.length ;i++ ){
            int nInc = arr[i] + oExc ;
            int nExc = Math.max(oInc,oExc);
            oInc = nInc ;
            oExc = nExc ;
        }
        int ans = Math.max(oInc,oExc);
        System.out.println(ans);
    }
}
