package com.dhruv.stack_ds.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        Stack<Integer> stk = new Stack<>();
        stk.push(Integer.MAX_VALUE);
        int[] ans = new int[nums.length];
        for( int i = nums.length-1 ; i>=0 ; i--) {
            int cur = nums[i] ;
            while( cur>=stk.peek() ){
                stk.pop() ;
            }
            ans[i] = stk.peek() ;
            stk.push(cur);
        }
        for( int i = 0 ; i<ans.length ; i++ ){
            if( ans[i] == Integer.MAX_VALUE ){
                ans[i] = -1;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
