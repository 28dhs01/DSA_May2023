package com.dhruv.binary_search;

import java.util.Arrays;

public class PeakElement2 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5,6,7,8},
                {2,3,4,5,6,7,8,9},
                {3,4,5,6,7,8,9,10},
                {4,5,6,7,8,9,10,11}
        };
        int[] ans = findPeakGrid(mat);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        int r = 0 ;
        int c = 0 ;
        while( r>=0 && c>=0 && r<n && c<m){
            int up = r-1<0?-1:mat[r-1][c];
            int ri = c+1>=m?-1:mat[r][c+1];
            int dw = r+1>=n?-1:mat[r+1][c];
            int lf = c-1<0?-1:mat[r][c-1];

            if( mat[r][c] > up && mat[r][c]> ri&& mat[r][c] > dw && mat[r][c]>lf ){
                return new int[]{r,c};
            }
            int maxi = Math.max( up, Math.max(ri, Math.max(lf,dw) ) );
            System.out.println(maxi) ;
            if( maxi == up ){
                r-- ;
            }else if( maxi == ri ){
                c++ ;
            }else if( maxi == dw ){
                r++ ;
            }else{
                c-- ;
            }
        }
        return new int[]{0,0};
    }
}
