package com.dhruv.company.jio;

import java.util.Arrays;

public class Jio {
    public static void main(String[] args) {
        String res = "dhruv.leetcode.com" ;
        String[] spt = res.split("\\.") ;
        System.out.println(Arrays.toString(spt));
        int ans = getCnt(15,2) ;
        System.out.println(ans);
    }
    static int getCnt(int x, int y){
        int cnt = 0 ;
        while( x>0 || y>0 ){
            int xLast = x&1 ;
            int yLast = y&1 ;
            if( xLast != yLast ){
                cnt++ ;
            }
            x = x>>1 ;
            y = y>>1 ;
        }
        return cnt ;
    }
}
