package com.dhruv.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByFreq {
    public static void main(String[] args) {
        int[] nums = {2,3,1,3,2};
        int[] ans = frequencySort(nums) ;
        System.out.println(Arrays.toString(ans));
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            int key = nums[i] ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1) ;
            }else{
                map.put(key,1) ;
            }
        }
        PriorityQueue<Pair> mnh = new PriorityQueue<>() ;
        for( int key : map.keySet() ){
            int val = map.get(key) ;
            mnh.add(new Pair(key,val)) ;
        }
        int [] res = new int[nums.length] ;
        int i = 0 ;
        while( !mnh.isEmpty() ){
            Pair peek = mnh.peek() ;
            for( int j = 0 ; j<peek.freq ; j++ ){
                res[i] = peek.val ;
                i++ ;
            }
            mnh.remove() ;
        }
        return res ;
    }
    static class Pair implements Comparable<Pair> {
        int val ;
        int freq ;
        Pair( int val , int freq ){
            this.val = val ;
            this.freq = freq ;
        }
        @Override
        public int compareTo(Pair o){
            if( this.freq != o.freq ){
                return this.freq - o.freq ;
            }
            return o.val - this.val ;
        }
    }
}
