package com.dhruv.queue.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SecretAwareness {
    public static void main(String[] args) {
        int n = 4 ;
        int delay = 1 ;
        int forget = 3 ;
        int ans = peopleAwareOfSecret(n,delay,forget) ;
        System.out.println(ans);
    }
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<Person> q = new ArrayDeque<>() ;
        for( int i = 0 ; i<n ; i++ ){
            if(i==0){
                q.add(new Person(1,1)) ;
            }else{
                addElements(q,forget,delay);
            }
        }
        return q.size() ;
    }
    static void addElements(Queue<Person>q, int forget, int delay){
        List<Person> list = new ArrayList<>() ;
        while( !q.isEmpty() ){
            Person peekPerson = q.peek() ;
            q.poll() ;
            if( peekPerson.days < forget && peekPerson.days >= delay ){
                list.add(new Person(1,1)) ;
            }
            if( peekPerson.days < forget ){
                list.add(peekPerson) ;
                peekPerson.days += 1 ;
            }
        }
        for ( int i = 0 ; i<list.size() ; i++ ){
            q.add(list.get(i)) ;
        }
    }
    static class Person{
        int num ;
        int days ;
        Person(int num, int days){
            this.num = num ;
            this.days= days ;
        }
    }
}
