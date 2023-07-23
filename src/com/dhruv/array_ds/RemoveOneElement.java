package com.dhruv.array_ds;

import java.util.ArrayList;

public class RemoveOneElement {
    public static void main(String[] args) {
        int [] nums = {1,2,10,5,7} ;
        boolean ans = canBeIncreasing(nums) ;
        System.out.println(ans);
    }
    public static boolean canBeIncreasing(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i<nums.length ; i++ ){
            list.add(nums[i]) ;
        }
        for( int i = 0 ; i<nums.length ; i++ ){
            list.remove(i) ;
            boolean chk = check(list,i);
            if( chk == true ){
                return true ;
            }
            list.add(i,nums[i]) ;
        }
        return false ;
    }
    static boolean check(ArrayList<Integer> list,int idx){
        for( int i = 0 ; i<list.size()-1 ; i++ ){
                if( list.get(i) >= list.get(i+1) ){
                    return false ;
                }
        }
        return true ;
    }
}
