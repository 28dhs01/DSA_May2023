package com.dhruv.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StoneWeight {
    public static void main(String[] args) {

        int [] stones = {2,7,4,1,8,1};
        PriorityQueue<Integer> mxh = new PriorityQueue<>(Comparator.reverseOrder());
        for( int stone: stones ){
            mxh.add(stone);
        }
        System.out.println(mxh);
        while( !mxh.isEmpty() && mxh.size() != 1 ){
            int fst = mxh.peek();
            mxh.poll();
            int scd = mxh.peek() ;
            mxh.poll();
            int diff = fst-scd ;
            if( diff > 0 ){
                mxh.add(fst-scd);
            }
            else if( diff<0 ){
                mxh.add(scd-fst);
            }
        }
        System.out.println(mxh.peek());
    }
}
