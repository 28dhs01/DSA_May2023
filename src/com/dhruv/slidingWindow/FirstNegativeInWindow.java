package com.dhruv.slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        long[] A = {-8,2,3,-6,-7,10,1,7};
        long[] ans = printFirstNegativeInteger(A,A.length,3);
        System.out.println(Arrays.toString(ans));
    }
    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans = new long[N-K+1];
        int i = 0 ;
        int j = 0 ;
        Queue<Long> q = new ArrayDeque<>();
        while ( j<A.length ){
            if( A[j] < 0 ){
                q.add(A[j]);
            }
            if( j-i+1 == K ){
                if( !q.isEmpty() ){
                    ans[i] = q.peek() ;
                }else{
                    ans[i] = 0 ;
                }
                if( q.contains(A[i]) ){
                    q.remove();
                }
                i++ ;
            }
            j++ ;

        }
        return ans ;

    }
}
