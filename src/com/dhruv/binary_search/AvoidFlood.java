package com.dhruv.binary_search;

import java.util.*;

public class AvoidFlood {
    public static void main(String[] args) {
        int[] rains = {1,2,0,2,3,0,1};
        int[] ans = avoidFlood(rains);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] avoidFlood(int[] rains) {
        Stack<Integer> stk = new Stack<>() ;
        int[] ans = new int[rains.length];
        for( int i = 0 ; i<ans.length ; i++ ){
            if( rains[i] == 0 ){
                if( !stk.isEmpty() ){
                    if( stk.contains(rains[i]) ){
                        ans[i] = rains[i];
                        stk.remove(rains[i]);
                    }else{
                        ans[i] = stk.pop();
                    }
                }else{
                    ans[i] = 1 ;
                }
            }else{
                ans[i] = -1;
                if( stk.contains(rains[i]) ){
                    return new int[] {};
                }
                stk.push(rains[i]);

            }
        }
        return ans ;
    }
}
