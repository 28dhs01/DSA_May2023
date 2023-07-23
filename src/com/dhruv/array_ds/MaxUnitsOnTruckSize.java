package com.dhruv.array_ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxUnitsOnTruckSize {
    public static void main(String[] args) {
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}} ;
        int truckSize = 10 ;
        int ans = maximumUnits(boxTypes,truckSize) ;
        System.out.println(ans);
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Pair> list = new ArrayList<>();
        for(int [] ar: boxTypes ){
            int boxes = ar[0] ;
            int units = ar[1] ;
            Pair p = new Pair(boxes,units);
            list.add(p) ;
        }
        Collections.sort(list);
//        for( Pair p: list ){
//            System.out.println(p.units);
//        }
        int mxUnits = 0 ;
        int boxCount = 0 ;
        int i = 0 ;
        while (boxCount < truckSize){
            int curBoxes = list.get(i).boxes ;
            boxCount += curBoxes ;
            if( boxCount == truckSize ){
                mxUnits += list.get(i).units * curBoxes ;
                break;
            }
            if(boxCount>truckSize){
                int dif = boxCount - truckSize ;
                mxUnits += list.get(i).units * dif ;
            }else {
                mxUnits += list.get(i).units*curBoxes ;
            }
            i++ ;
        }
        return mxUnits ;
    }
    static class Pair implements Comparable<Pair>{
        int boxes ;
        int units ;
        Pair(int boxes, int units){
            this.boxes = boxes ;
            this.units = units ;
        }

        @Override
        public int compareTo(Pair o) {
            return -(this.units-o.units);
        }
    }
}
