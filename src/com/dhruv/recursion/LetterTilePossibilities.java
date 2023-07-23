package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB" ;
        int n = numTilePossibilities(tiles) ;
        System.out.println(n);
    }
    public static int numTilePossibilities(String tiles) {
        List<String> list = new ArrayList<>();
        makeList(tiles,0,"",list);
        System.out.println(list);
        return list.size() ;
    }
    static void makeList(String original, int curIdx, String ssf , List<String> list){
        if( curIdx == original.length() ){
            if( !list.contains(ssf) && ssf != ""){
//                System.out.println(ssf);
                list.add(ssf) ;
            }
            return;
        }
        int len = ssf.length() ;
        char cur = original.charAt(curIdx) ;
        for( int i = 0 ; i<=len ; i++ ){
            String f = ssf.substring(0,i);
            String s = ssf.substring(i,len) ;
            makeList(original,curIdx+1,f+cur+s,list);
        }
        makeList(original,curIdx+1,ssf,list);
    }

}
