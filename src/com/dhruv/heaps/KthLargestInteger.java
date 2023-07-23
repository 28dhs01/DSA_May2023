package com.dhruv.heaps;

import java.util.PriorityQueue;

public class KthLargestInteger {
    public static void main(String[] args) {
        String[] nums = {"1","0","0"} ;
        String res = kthLargestNumber(nums,2) ;
        System.out.println(res);
    }
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<Pair> mnh = new PriorityQueue<>() ;
        for( int i = 0 ; i<nums.length ; i++ ){
            String cur = nums[i] ;
            if( mnh.size() < k ){
                mnh.add(new Pair(cur)) ;
            }else{
                String peek = mnh.peek().str ;
                if( cur.length() > peek.length() ){
                    mnh.poll() ;
                    mnh.add(new Pair(cur)) ;
                }else if( cur.length() == peek.length() ){
                    boolean curBigger = check(peek,cur) ;
                    if( curBigger == true ){
                        mnh.poll() ;
                        mnh.add(new Pair(cur)) ;
                    }else{
                        continue ;
                    }
                }else{
                    continue ;
                }
            }
//            System.out.println(mnh);
        }
        return mnh.peek().str ;
    }
    static class Pair implements Comparable<Pair>{
        String str ;
        int len ;
        Pair(String str ){
            this.str = str ;
            this.len = str.length() ;
        }

        @Override
        public int compareTo(Pair o) {
            if( this.len != o.len ){
                return this.len-o.len;
            }else{
                int ptr1 = 0 ;
                int ptr2 = 0 ;
                while( ptr1<this.len ){
                    int c1 = this.str.charAt(ptr1) ;
                    int c2 = o.str.charAt(ptr2) ;
                    if( c1 > c2 ){
                        return 1 ;
                    }
                    if( c2 > c1 ){
                        return -1 ;
                    }
                    ptr1++ ;
                    ptr2++ ;
                }
                return 1 ;
            }
        }
    }
    static boolean check ( String peek , String cur ){
        int ptr1 = 0 ;
        int ptr2 = 0 ;
        while( ptr1<peek.length() ){
            int c1 = peek.charAt(ptr1) ;
            int c2 = cur.charAt(ptr2) ;
            if( c1 > c2 ){
                return false ;
            }
            if( c2 > c1 ){
                return true ;
            }
            ptr1++ ;
            ptr2++ ;
        }
        return false ;
    }
}
