package com.dhruv.recursion;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {
    public static void main(String[] args) {
        int ans = lastRemaining(9) ;
        System.out.println(ans);
    }
    public static int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>() ;
        for( int i = 1 ; i<= n ; i++ ){
            list.add(i) ;
        }
        helper(list,true) ;
        return list.get(0) ;
    }
    static void helper(List<Integer>list, boolean lftToRgt ){
        System.out.println(list);
        if( list.size() == 1 ){
            return ;
        }
        if( lftToRgt ){
            for( int i = 0 ; i<list.size() ; i++ ){
                list.remove(i) ;
                if( list.size() == 1 ){
                    return ;
                }
            }
            helper(list,false) ;
        }
        if( !lftToRgt ){
            for( int i = list.size()-1 ; i>=0 ;  i = i-2 ){
                list.remove(i) ;
                if( list.size() == 1 ){
                    return ;
                }
            }
            helper(list,true) ;
        }

    }
}
