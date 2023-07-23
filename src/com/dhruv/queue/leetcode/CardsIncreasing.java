package com.dhruv.queue.leetcode;

import java.util.*;

public class CardsIncreasing {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7,25} ;
        Arrays.sort(deck) ;
        Queue<Integer> idxQ = new ArrayDeque<>();
        for( int i = 0 ; i<deck.length ; i++ ){
            idxQ.add(i) ;
        }
        int[]res = new int[deck.length] ;
        for( int i = 0 ; i<res.length ; i++ ){
            if( !idxQ.isEmpty() ){
                res[idxQ.poll()] = deck[i] ;
                if( !idxQ.isEmpty() ){
                    idxQ.add(idxQ.poll());
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
