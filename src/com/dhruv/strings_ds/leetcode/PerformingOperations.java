package com.dhruv.strings_ds.leetcode;

public class PerformingOperations {
    public static void main(String[] args) {
        String[] operations = {"--X","X++","X++"};
        int ans = finalValueAfterOperations(operations) ;
        System.out.println(ans);
    }
    public static int finalValueAfterOperations(String[] operations) {
        int ans = 0 ;
        for( int i = 0 ; i<operations.length ; i++ ){
            String cur = operations[i] ;
            if ( cur.contains("+")){
                ans++ ;
            }else{
                ans-- ;
            }
        }
        return ans;
    }
}
