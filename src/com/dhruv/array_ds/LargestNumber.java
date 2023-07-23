package com.dhruv.array_ds;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] ar = {3,30,34,5,9} ;
        String ans = largestNumber(ar) ;
        System.out.println(ans);
    }
    public static String largestNumber(int[] nums) {
        String [] asStr = new String[nums.length] ;
        for (int i = 0 ; i<asStr.length ; i++ ){
            asStr[i] = String.valueOf(nums[i]) ;
        }
        Arrays.sort(asStr, new CompareLargest());
        String res = "" ;
        for( int i = 0 ; i< asStr.length ; i++ ){
            res += asStr[i] ;
        }
        return res ;
    }
    static class CompareLargest implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String order1 = a+b ;
            String order2 = b+a ;
            return order2.compareTo(order1);
        }
    }
}
