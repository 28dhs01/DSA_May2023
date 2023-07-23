package com.dhruv.stack_ds.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        int [] ans = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for( int i = nums.length-1 ; i>=0 ; i-- ){
            int cur = nums[i] ;
            while( cur <= stk.peek() ){
                stk.pop();
            }
            ans[i] = stk.peek();
            stk.push(cur);
        }
        System.out.println(Arrays.toString(ans));
    }
}
