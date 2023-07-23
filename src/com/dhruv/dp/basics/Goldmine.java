package com.dhruv.dp.basics;

import java.util.Scanner;

public class Goldmine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for( int i = 0 ; i<n ; i++ ){
            for( int j = 0 ; j<m ;j++ ){
                arr[i][j] = sc.nextInt();
            }
        }
        int [][] dp = new int[n][m] ;
        for( int col = dp[0].length - 1 ; col >= 0 ; col-- ){
            for ( int row = dp.length -1 ; row>=0 ; row -- ){
                if ( col == dp[0].length -1 ){
                    dp[row][col] = arr[row][col];
                }else if( row == dp.length -1 ){
                    dp[row][col] = arr[row][col] + Math.max(dp[row-1][col+1],dp[row][col+1]);
                }else if( row == 0 ){
                    dp[row][col] = arr[row][col] + Math.max(dp[row+1][col+1],dp[row][col+1]);
                }else {
                    int max = Math.max(dp[row-1][col+1],dp[row][col+1]);
                    max = Math.max(max, dp[row+1][col+1]);
                    dp[row][col] = arr[row][col] + max;
                }
            }
        }
        int maxGold = dp[0][0] ;
        for ( int row = 1 ; row<dp.length ;row++ ){
            if( dp[row][0] > maxGold ){
                maxGold = dp[row][0] ;
            }
        }
        System.out.println(maxGold);

    }
}
