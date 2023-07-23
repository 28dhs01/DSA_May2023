package com.dhruv.hashmap_ds.implementation;

import java.util.LinkedList;

public class MyHashMap {
    class Node {
        int key ;
        int val ;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    LinkedList<Node>[] bucket ;
    int bucketSize ;
    int totalNodes ;
    public MyHashMap() {
        this.bucketSize = 769 ;
        this.bucket = new LinkedList[bucketSize];
        for( int i = 0 ; i<bucketSize ; i++ ){
            bucket[i] = new LinkedList<>();
        }
    }
    public void put(int key, int value) {
        int bi = hshFnc(key) ;
        int di = idxWithinLL(key,bi);
        if( di != -1 ){
//            key already there
            Node node = bucket[bi].get(di);
            node.val = value ;
        }else{
            Node node = new Node(key,value);
            bucket[bi].add(node);
            totalNodes++ ;
        }
        double lambda =  (totalNodes*1.0/bucketSize);
        if(lambda>2){
//            do something
            rehash();
        }

    }
    public void rehash(){
        LinkedList<Node> [] dummy = new LinkedList[2*bucketSize];
        totalNodes = 0 ;
        for( int i = 0 ; i<dummy.length ; i++ ){
            dummy[i] = new LinkedList<>();
        }
        for( int i = 0 ; i<bucketSize ; i++ ){
            for( Node node : bucket[i] ){
                put(node.key,node.val);
            }
        }
        bucketSize = dummy.length;
        bucket = dummy ;
    }



    int hshFnc(Integer key){
        int hc = key.hashCode();
        return Math.abs(hc)%bucket.length;
    }
    int idxWithinLL(int key, int bi){
        int di = 0 ;
        for (Node node : bucket[bi]) {
            if( node.key == key ){
                return di ;
            }
            di++ ;
        }
        return -1 ;
    }

    public int get(int key) {
        int bi = hshFnc(key);
        int di = idxWithinLL(key,bi);
        if( di == -1 ){
            return -1;
        }
        return bucket[bi].get(di).val;
    }

    public void remove(int key) {
        int bi = hshFnc(key) ;
        int di = idxWithinLL(key,bi);
        if( di != -1 ){
            bucket[bi].remove(di);
        }
    }
}
