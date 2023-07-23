package com.dhruv.company;

import java.util.HashSet;
import java.util.Set;

public class DistinctCnt {
    public static void main(String[] args) {

        String str = "eckpbbhy" ;
        int k = 2 ;
        int cnt=0 ;
        Set<Character> set = new HashSet<>() ;
        for( int i = 0 ; i<str.length() ; i++ ){
            set.add(str.charAt(i)) ;
            if( set.size()>k ){
                cnt++ ;
                set = new HashSet<>();
                set.add(str.charAt(i)) ;
            }
        }
        if( set.size()<=k ){
            cnt++ ;
        }
        System.out.println(cnt);
    }
}
