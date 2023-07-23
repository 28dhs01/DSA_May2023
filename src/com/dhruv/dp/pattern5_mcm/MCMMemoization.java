package com.dhruv.dp.pattern5_mcm;

public class MCMMemoization {
    public static void main(String[] args) {
        int n = 5 ;
        int[] arr = {40, 20, 30, 10, 30} ;
        int ans = matrixMultiplication(n,arr) ;
        System.out.println(ans);
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int [][]memo = new int[N][N] ;
        for( int r = 0 ; r<memo.length ; r++ ){
            for (int c = 0 ; c<memo[0].length ;c++ ){
                memo[r][c] = -1 ;
            }
        }
        return solve(arr,1,N-1,memo);
    }
    static int solve( int[] arr, int i, int j , int[][]memo){
        if( i>=j ){
            return 0 ;
        }
        if( memo[i][j] != -1 ){
            return memo[i][j] ;
        }
        int mn = Integer.MAX_VALUE ;
        for( int k = i; k<j ; k++ ){
            int tmpAns = solve(arr,i,k,memo) + solve(arr,k+1,j,memo) + arr[i-1]*arr[k]*arr[j] ;
            mn = Math.min(mn,tmpAns) ;
        }
        memo[i][j] = mn ;
        return mn ;
    }
}
