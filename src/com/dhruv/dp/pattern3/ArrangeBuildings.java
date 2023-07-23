package com.dhruv.dp.pattern3;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int plots = sc.nextInt() ;
        int ob = 1 ;
        int os = 1 ;
        for( int i = 2 ; i<= plots ; i++ ){
            int nb = os ;
            int ns = ob + os;
            os = ns ;
            ob = nb ;
        }
        long wps = ob+os ;
        System.out.println(wps);
        long wbs = wps*wps ;
        System.out.println(wbs);
    }
}
