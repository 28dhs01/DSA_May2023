package com.dhruv.strings_ds.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CellsInRange {
    public static void main(String[] args) {
        String  s = "K1:L2" ;
//        System.out.println((char)('K'+1));
        List<String> list = cellsInRange(s) ;
        System.out.println(list);
    }
    public static List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        for( char i = s.charAt(0) ; i<=s.charAt(3); i++ ){
            for( int j = s.charAt(1) ; j<=s.charAt(4) ; j++ ){
                list.add(i+""+(char)j);
            }
        }
        return list ;
    }
}
