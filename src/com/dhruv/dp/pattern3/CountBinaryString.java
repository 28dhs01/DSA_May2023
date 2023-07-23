package com.dhruv.dp.pattern3;

import java.util.Arrays;
import java.util.Scanner;

public class CountBinaryString {
    public static void main(String[] args) {
        int n = 5 ;
//        can be solved in O(1)
        int[] zar = new int[n+1] ;
        int [] oar = new int[n+1] ;
        zar[0] = 0 ;
        oar[0] = 0 ;
        zar[1] = 1 ;
        oar[1] = 1 ;
        for( int i = 2 ; i<zar.length ; i++ ){
            zar[i] = oar[i-1];
            oar[i] = oar[i-1] + zar[i-1];
        }
        System.out.println(Arrays.toString(zar));
        System.out.println(Arrays.toString(oar));
        System.out.println(zar[n]+oar[n]);
    }
    static void otherWay(){
        System.out.println("enter the value of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        int oz = 1 ;
        int oo = 1 ;
        for( int i=2 ; i<=n ; i++ ){
            int nz = oo ;
            int no = oz + oo ;
            oz = nz ;
            oo = no ;
        }
        System.out.println(oz+oo);
    }
}
