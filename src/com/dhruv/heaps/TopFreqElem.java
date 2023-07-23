package com.dhruv.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFreqElem {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3} ;
        int k = 2 ;
        topKFrequent(nums,k);

    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            int key = nums[i] ;
            if( map.containsKey(key) ){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        System.out.println(map);

        PriorityQueue<Integer> mnh = new PriorityQueue<>((a,b)->(map.get(a)-map.get(b)));
        for( int key : map.keySet() ){
            mnh.add(key) ;
            if( mnh.size() > k ){
                mnh.poll() ;
            }
        }
        System.out.println(mnh);
        int[] arr=new int[mnh.size()] ;
        int i = 0 ;
        while( mnh.size()>0 ){
            arr[i] = mnh.poll() ;
            i++ ;
        }
        System.out.println(Arrays.toString(arr));
        return arr ;
    }
}
