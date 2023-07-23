package com.dhruv.slidingWindow;
// this solution is incorrect
public class NonOverlappingSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,0,9,5,0,3,8} ;
        int firstLen = 4 ;
        int secondLen = 3 ;
        int res = maxSumTwoNoOverlap(nums,firstLen,secondLen) ;
        System.out.println(res);
    }
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length ;
        boolean [] vst = new boolean[n] ;
        int f = slidingWindow(nums,vst,firstLen) ;
        System.out.println(f) ;
        int s = slidingWindow(nums,vst,secondLen) ;
        System.out.println(s) ;
        return f+s ;
    }
    static int slidingWindow(int[] nums,boolean[] vst, int size){
        int i = 0 ;
        int j = 0 ;
        int n = nums.length ;
        int stvi = -1 ;
        int edvi = -1 ;
        int mxSum = Integer.MIN_VALUE ;
        int curSum = 0 ;
        while( j<n ){
            while( vst[j] == true ){
                j++ ;
                i = j ;
                curSum = 0 ;
            }
            curSum += nums[j] ;
            if( j-i == size-1 ){
                if( curSum > mxSum ){
                    mxSum = curSum ;
                    stvi = i ;
                    edvi = j ;
                }
                // mxSum = Math.max(mxSum,curSum) ;
                curSum -= nums[i] ;
                i++ ;
            }
            j++ ;
        }
        for( int k = stvi ; k<= edvi ; k++ ){
            vst[k] = true ;
        }

        System.out.println(stvi +" "+edvi) ;
        return mxSum ;
    }
}
