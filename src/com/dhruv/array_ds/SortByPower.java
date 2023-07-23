package com.dhruv.array_ds;

import java.util.Arrays;
import java.util.Comparator;

public class SortByPower {
    public static void main(String[] args) {
        int ans = getKth(7,11,4);
        System.out.println(ans);
    }
    public static int getKth(int lo, int hi, int k) {
        Pair []pair = new Pair[hi-lo+1] ;
        for( int i = 0 ; i<pair.length ;i++ ){
            int res = powVal(i+lo,0) ;
            int key = lo+i ;
            pair[i] = new Pair(key,res) ;
        }
        for( int i = 0 ; i< pair.length ; i++ ){
            System.out.println(pair[i].key +" - "+ pair[i].val);
        }
        System.out.println();
        Arrays.sort(pair, Comparator.comparingInt(a->a.val));
        for( int i = 0 ; i< pair.length ; i++ ){
            System.out.println(pair[i].key +" - "+ pair[i].val);
        }
        return pair[k-1].key ;

    }
    static int powVal(int n, int count){
        if( n == 1 ){
            return count ;
        }
        if( n%2 == 0 ){
            return powVal(n/2,count+1) ;
        }else{
            return powVal(3*n+1,count+1) ;
        }
    }
    static class Pair{
        int key ;
        int val ;
        Pair(int k, int v ){
            this.key = k ;
            this.val = v ;
        }
    }
}
