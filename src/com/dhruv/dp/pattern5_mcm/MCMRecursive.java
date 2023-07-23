package com.dhruv.dp.pattern5_mcm;

public class MCMRecursive {
    public static void main(String[] args) {
        int n = 5 ;
        int[] arr = {40, 20, 30, 10, 30} ;
        int ans = matrixMultiplication(n,arr) ;
        System.out.println(ans);
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        return solve(arr,1,N-1);
    }
    static int solve( int[] arr, int i, int j ){
        if( i>=j ){
            return 0 ;
        }
        int mn = Integer.MAX_VALUE ;
        for( int k = i; k<j ; k++ ){
            int tmpAns = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j] ;
            mn = Math.min(mn,tmpAns) ;
        }
        return mn ;
    }
}
