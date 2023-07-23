package com.dhruv.company;

public class WinnerAndRunner {
    public static void main(String[] args) {
        int[] ar = {8,2,10,6,15} ;
        int winner = ar[0] ;
        int runner = ar[0] ;
        for( int i = 1 ; i<ar.length ; i++ ){
            if( ar[i] > winner) {
                runner = winner ;
                winner = ar[i] ;
            }else if(ar[i] > runner){
                runner = ar[i] ;
            }
        }
        System.out.println(winner);
        System.out.println(runner);
    }
}
