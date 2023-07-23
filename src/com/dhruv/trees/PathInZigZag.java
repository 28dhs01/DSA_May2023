package com.dhruv.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigZag {
    public static void main(String[] args) {
        List<Integer> ansList = pathInZigZagTree(13);
        System.out.println(ansList);

    }
    static public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(label,list);
        System.out.println(list);
        Collections.reverse(list);
        return list ;
    }
    static void helper( int label , ArrayList<Integer> list ){
        if( label == 1 ){
            list.add(1);
            return;
        }
        int lvl = 0 ;
        while ( label >= Math.pow(2,lvl) ){
            lvl ++ ;
        }
        lvl = lvl -1 ;
        int s = (int) Math.pow(2,lvl);
        int e = (int) (Math.pow(2,lvl+1)-1);
//        System.out.println(s);
//        System.out.println(e);
        ArrayList<Integer> lvlElements = new ArrayList<>();
        for( int i = s ; i<=e ; i++ ){
            lvlElements.add(i);
        }
//        System.out.println(lvlElements);
        int diff = e - label ;

        int complement = s + diff ;
//        System.out.println(complement);
        list.add(label);
        helper(complement/2,list);
    }

}
