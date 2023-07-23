package com.dhruv.dp.level2;

import java.util.Arrays;

public class KnightsProb {
    public static void main(String[] args) {
        double ans = knightProbability(5,2,2,2);
        System.out.println(ans);
    }
    static public double knightProbability(int n, int k, int row, int column) {
        double [][] cur = new double[n][n] ;
        double [][] nxt = new double[n][n] ;
        cur[row][column] = 1.0 ;
        for ( int count = 0 ; count<k ; count++ ){
            for( int i = 0 ; i<cur.length ; i++ ){
                for (int j = 0 ; j<cur[i].length ; j++ ){
                    if( cur[i][j] != 0 ){
                        int newi = i-2 ;
                        int newj = j+1 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i-1 ;
                        newj = j+2 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i+1 ;
                        newj = j+2 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i+2 ;
                        newj = j+1 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i+2 ;
                        newj = j-1 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i+1 ;
                        newj = j-2 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i-1 ;
                        newj = j-2 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }

                        newi = i-2 ;
                        newj = j-1 ;
                        if( isPossible( n, newi, newj ) ){
                            nxt[newi][newj] += cur[i][j]/8 ;
                        }
                    }
                }
            }
            cur = nxt ;
            for( double []p : cur){
                System.out.println(Arrays.toString(p));
            }
            System.out.println();
            nxt = new double[n][n];
        }
        double ans = 0 ;
        for( int i = 0 ; i<cur.length ;i++ ){
            for( int j = 0 ; j<cur[i].length ; j++ ){
                ans += cur[i][j] ;
            }
        }
        return ans ;
    }
    static boolean isPossible( int n , int r, int c ){
        if( r<0 || c<0 || r>=n ||c>=n ){
            return false ;
        }
        return true;
    }
}
