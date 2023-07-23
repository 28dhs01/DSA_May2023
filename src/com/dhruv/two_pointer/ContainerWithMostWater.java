package com.dhruv.two_pointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7} ;
        int ans = maxArea(height) ;
        System.out.println(ans);
        System.out.println(twoPtr(height));
    }
    public static int maxArea(int[] height) {
        int mxWater = Integer.MIN_VALUE ;
        for( int i = 0 ; i<height.length ; i++ ){
            for( int j = i+1; j< height.length ; j++ ){
                int ht = Math.min(height[i],height[j]);
                int wd = j-i ;
                int area = ht*wd ;
                mxWater = Integer.max(mxWater,area);
            }
        }
        return mxWater ;
    }
    static int twoPtr(int[]height){
        int mxWater = Integer.MIN_VALUE ;
        int s = 0 ;
        int e = height.length-1 ;
        while( s<e ){
            int ht = Math.min(height[s],height[e]);
            int wd = e-s ;
            int area = ht*wd ;
            mxWater = Math.max(area,mxWater);
            if( height[s]> height[e]){
                e-- ;
            }else {
                s++ ;
            }
        }
        return mxWater ;
    }
}
