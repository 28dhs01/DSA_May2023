package com.dhruv.trees;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        applyBfs(root,outerList) ;
        return outerList ;
    }
    static void applyBfs(TreeNode root, List<List<Integer>>outerList ){
        Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,0)) ;
        TreeNode dmy = new TreeNode(-1) ;
        q.add(new Pair(dmy,0)) ;
        while (!q.isEmpty()){
            Pair peekPair = q.peek() ;
            TreeNode peekNode = peekPair.node ;
            int currentHorizontalDistance = peekPair.hd;
//            r m* w a*
            q.poll() ;
            if( peekNode == dmy ){
                if( !q.isEmpty() ){
                    q.add(new Pair(dmy,0)) ;
                }
                continue;
            }
            int mapKey = currentHorizontalDistance  ;
            if( map.containsKey(mapKey) ){
                List<Integer> list = map.get(mapKey) ;
                list.add(peekNode.val) ;
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(peekNode.val) ;
                map.put(mapKey,list) ;
            }
            if( peekNode.left != null ){
                q.add(new Pair(peekNode.left,currentHorizontalDistance-1));
            }
            if( peekNode.right != null ){
                q.add(new Pair(peekNode.right,currentHorizontalDistance+1));
            }
        }
        for( int key: map.keySet() ){
            outerList.add(map.get(key)) ;
        }
    }
    static class Pair{
        TreeNode node ;
        int hd ;
        Pair(TreeNode node , int hd){
            this.node = node ;
            this.hd = hd ;
        }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
