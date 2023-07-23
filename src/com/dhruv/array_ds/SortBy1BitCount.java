package com.dhruv.array_ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortBy1BitCount {
    public static void main(String[] args) {
        int[] ar = {0,1,2,3,4,5,6,7,8} ;
        int[] ans = sortByBits(ar) ;
        System.out.println(Arrays.toString(ans));
    }
    public static int[] sortByBits(int[] arr) {
        Pair[] ans = new Pair[arr.length] ;
        for ( int i = 0 ; i<arr.length ; i++ ){
            int key = arr[i];
            int val = cnt1Bits(key) ;
            ans[i] = new Pair(key,val) ;
        }
        for( int i = 0 ; i<ans.length ; i++ ){
            System.out.println(ans[i].key +" -> " +ans[i].val);
        }
        Arrays.sort(ans);
        int[] actualAns = new int[ans.length] ;
        for( int i = 0 ; i<actualAns.length ; i++ ){
            actualAns[i] = ans[i].key ;
        }
        return actualAns ;
    }
    static int cnt1Bits(int num){
        int cnt = 0 ;
        while( num>0 ){
            if( (num&1) == 1 ){
                cnt++ ;
            }
            num = num>>1 ;
        }
        return cnt ;
    }
    static class Pair implements Comparable<Pair>{
        int key ;
        int val ;
        Pair(int key, int val){
            this.key = key ;
            this.val = val ;
        }
        @Override
        public int compareTo(Pair o) {
            if( this.val == o.val ){
                return this.key-o.key ;
            }
            return this.val-o.val;
        }

    }
}
