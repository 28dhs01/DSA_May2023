package com.dhruv.game_theory;

public class PredictWinner {
    public static void main(String[] args) {
        int[] nums = {1,5,233,7} ;
        boolean res = PredictTheWinner(nums) ;
        System.out.println(res);
    }
    public static boolean PredictTheWinner(int[] nums) {
        int totalScore = 0 ;
        for( int i = 0 ; i<nums.length ; i++ ){
            totalScore += nums[i] ;
        }
        int scoreA = helper(nums,0,nums.length-1) ;
        int scoreB = totalScore - scoreA ;
        return scoreA >= scoreB ;
    }
    //     do the best expect the worst strategy
    static int helper(int[] nums,int s, int e){
        if ( s>e ){
            return 0 ;
        }
        int lftChoice = nums[s] + Math.min( helper(nums,s+2,e), helper(nums,s+1,e-1) ) ;
        int rgtChoice = nums[e] + Math.min(helper(nums,s+1,e-1) , helper(nums,s,e-2)) ;
        return Math.max( lftChoice,rgtChoice );
    }
}
