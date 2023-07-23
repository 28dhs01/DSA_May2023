package com.dhruv.dp.leetcode;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10} ;
        int k = 3 ;
        int ans = maxSumAfterPartitioning(arr,k) ;
        System.out.println(ans);
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
//        return helper(arr,k,0);
        int dp[]=new int[arr.length+1];

        for(int i=arr.length-1;i>=0;i--){
            int max=0;
            int len=0;
            int maxSum=0;
            for(int index=i;index<Math.min(i+k,arr.length);index++){
                len++;
                max= Math.max(max,arr[index]);
                maxSum=Math.max(maxSum,(max*len)+dp[index+1]);

            }
            dp[i]=maxSum;
        }
        return dp[0];

    }
    static int helper(int[] arr, int k, int idx ){
        if( idx == arr.length ){
            return 0 ;
        }
        int len = 0 ;
        int maxi = Integer.MIN_VALUE ;
        int mxSum = Integer.MIN_VALUE ;
        int sum = Integer.MIN_VALUE ;
        for( int j = idx ; j<idx+k && j<arr.length ; j++ ){
            len++ ;
            maxi = Math.max(maxi,arr[j]) ;
            sum = len*maxi + helper(arr,k,j+1);
            mxSum = Math.max(mxSum,sum) ;
        }
        return mxSum ;
    }


}
