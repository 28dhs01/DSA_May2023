package com.dhruv.recursion;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}} ;
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return count(obstacleGrid,0,0);
    }
    static int count(int[][]obs, int r, int c){
        if( r == obs.length || c== obs[0].length ){
            return 0 ;
        }
        if( obs[r][c] == 1 ){
            return 0 ;
        }
        if( r==obs.length-1 && c== obs[0].length- 1 ){
            return 1 ;
        }
        int curCallCnt = 0 ;
        int downCnt = count(obs,r+1,c) ;
        int rightCnt = count(obs,r,c+1) ;
        curCallCnt += downCnt+rightCnt ;
        return curCallCnt ;
    }
}
