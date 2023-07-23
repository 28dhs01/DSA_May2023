package com.dhruv.recursion;

import java.util.Arrays;

public class ExecuteInstructions {
    public static void main(String[] args) {
        int n = 3 ;
        int[] startPos = {0,1} ;
        String s = "RRDDLU" ;
        int [] res = executeInstructions(n,startPos,s) ;
        System.out.println(Arrays.toString(res));
    }
    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()] ;
        int r = startPos[0] ;
        int c = startPos[1] ;
        for( int i = 0 ; i<res.length ; i++ ){

            res[i] = makeMoves(n,r,c,s,i) ;
        }
        return res ;
    }
    static int makeMoves(int n, int r, int c, String s, int curIdx){
        if( r<0 || r==n || c<0 || c == n ){
            return -1 ;
        }
        if( curIdx == s.length() ){
            return 0 ;
        }
        char ch = s.charAt(curIdx) ;
        if( ch == 'U' ){
            return 1+makeMoves(n,r-1,c,s,curIdx+1) ;
        }
        else if( ch == 'R'){
            return 1+makeMoves(n,r,c+1,s,curIdx+1) ;
        }
        else if ( ch == 'D' ){
            return 1+makeMoves(n,r+1,c,s,curIdx+1) ;
        }
        else{
//             L
            return 1+makeMoves(n,r,c-1,s,curIdx+1) ;
        }
    }
}
