package com.dhruv.strings_ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfNumbersAreAscending {
    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles" ;
        boolean res = areNumbersAscending(s) ;
        System.out.println(res);
    }
    public static boolean areNumbersAscending(String s) {
        String [] str = s.split(" ") ;
        for( String st : str ){
            System.out.println(st);
        }
        List<Integer> list = new ArrayList<>();
        for( int i = 0 ; i<str.length ; i++ ){
            char one = str[i].charAt(0) ;
            if( one >=97 && one <= 122 ){
                continue;
            }else{
                list.add(Integer.parseInt(str[i])) ;
            }
        }
        System.out.println(list);
        for( int i = 1 ; i<list.size() ; i++ ){
            if( list.get(i)<=list.get(i-1)){
                return false ;
            }
        }
        return true ;
    }
}
