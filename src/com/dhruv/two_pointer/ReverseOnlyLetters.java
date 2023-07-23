package com.dhruv.two_pointer;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "7_28]" ;
        String res = reverseOnlyLetters(s) ;
        System.out.println(res);
    }
    public static String reverseOnlyLetters(String s) {
        char[] ar = s.toCharArray() ;
        int ptr1 = 0 ;
        int ptr2 = ar.length-1 ;
        while( ptr1<ptr2 ){
            boolean flag = false ;
            while( !Character.isLetter(ar[ptr1]) ){
                ptr1++ ;
                if( ptr1>=ptr2 ){
                    flag = true ;
                    break;
                }
            }
            if( flag == true ){
                break;
            }
            while( !Character.isLetter(ar[ptr2]) ){
                ptr2-- ;
                if( ptr1>=ptr2 ){
                    flag = true ;
                    break;
                }
            }
            if( flag == true ){
                break;
            }
            swap(ar,ptr1,ptr2) ;
            ptr1++ ;
            ptr2-- ;
        }
        StringBuilder sb = new StringBuilder() ;
        for( int i = 0 ; i<ar.length ; i++ ){
            sb.append(ar[i]) ;
        }
        return sb.toString() ;
    }
    static void swap(char[]ar , int f, int s ){
        char temp = ar[f] ;
        ar[f] = ar[s] ;
        ar[s] = temp ;
    }
}
