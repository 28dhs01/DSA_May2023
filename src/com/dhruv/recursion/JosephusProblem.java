package com.dhruv.recursion;

import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5 ;
        int k = 2 ;
        int ans = findTheWinner(n,k) ;
        System.out.println(ans);
    }
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>() ;
        for( int i = 0 ; i<n ; i++ ){
            list.add(i+1) ;
        }
        int ans = helper( list,0,k );
        return ans ;
    }
    static int helper( ArrayList<Integer> list , int curIdx , int k ){
        if (list.size()==1){
            return list.get(0) ;
        }
        int rmvIdx = (curIdx+k-1)%list.size() ;
        list.remove(rmvIdx) ;
        int ans = helper( list, rmvIdx,k );
        return ans ;
    }
}
