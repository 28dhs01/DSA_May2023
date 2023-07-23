package com.dhruv.stack_ds.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class StudentUnableToEat {
    public static void main(String[] args) {
        int [] students = {1,1,1,0,0,1};
        int [] sandwiches = {1,0,0,0,1,1};
        int ans = countStudents(students,sandwiches);
        System.out.println(ans);
    }
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> sdws = new ArrayDeque<>() ;
        for( int i = 0 ; i<sandwiches.length ; i++ ){
            sdws.add(sandwiches[i]);
        }
//        System.out.println(sdws) ;
        Queue<Integer> stnt = new ArrayDeque<>();
        for( int i = 0 ; i<students.length ; i++ ){
            stnt.add(students[i]);
        }
        while( stnt.contains(sdws.peek()) && !stnt.isEmpty() ){
            if( sdws.peek() == stnt.peek() ){
                sdws.remove();
                stnt.remove();
            }else{
                int student = stnt.peek() ;
                stnt.remove();
                stnt.add(student);
            }
        }
        if( stnt.isEmpty() ){
            return 0 ;
        }
        return stnt.size() ;
    }
}
