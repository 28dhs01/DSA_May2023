package com.dhruv.strings_ds.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aaab" ;
        List<List<String>> ansList = partition(s);
        for( List<String> inList: ansList ){
            System.out.println(inList);
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> outerList = new ArrayList<>() ;
        char[] charArr = s.toCharArray();
        List<String> innerList = new ArrayList<>();
        makeList(charArr,outerList,innerList,0);
        List<List<String>> myList = new ArrayList<>();
        for( List<String> inList: outerList ){
//            System.out.println(inList);
            boolean flag = true ;
            for( String str: inList ){
                if( isPalindrome(str) == false ){
                    flag = false ;
                    break;
                }
            }
            if( flag == true ){
                myList.add(inList) ;
            }
        }
        return myList ;
    }

    private static boolean isPalindrome(String str) {
        int s = 0 ;
        int e = str.length()-1 ;
        while (s<=e){
            if( str.charAt(s) != str.charAt(e) ){
                return false ;
            }
            s++ ;
            e-- ;
        }
        return true ;
    }

    static void makeList(char[]charArr , List<List<String>> outerList, List<String> innerList, int curIdx){
        if( curIdx == charArr.length ){
            List<String> dmyList = new ArrayList<>();
            for( int i = 0 ; i<innerList.size() ; i++ ){
                dmyList.add(innerList.get(i));
            }
            outerList.add(dmyList) ;
//            System.out.println(innerList);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ptr = 1 ;
        for( int i = curIdx ; i< charArr.length ; i++ ){
            sb.append(charArr[i]);
            innerList.add(sb.toString());
            makeList(charArr,outerList,innerList,curIdx+ptr);
            ptr++ ;
            innerList.remove(innerList.size()-1);
        }
    }
}
