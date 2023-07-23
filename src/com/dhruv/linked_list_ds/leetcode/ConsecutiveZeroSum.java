package com.dhruv.linked_list_ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsecutiveZeroSum {
    public static void main(String[] args) {

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode resNode = new ListNode(1) ;
        resNode.next = head ;
        Map<Integer,ListNode> map = new HashMap<>() ;
        ListNode curNode = head ;
        int sum = 0 ;
        map.put(0,resNode) ;
        while( curNode != null ){
            sum+=curNode.val ;
            if( map.containsKey(sum) ){
                ListNode stNode = map.get(sum) ;
                ListNode toBeRemoved = stNode.next ;
                int sumToBeRemoved = sum ;
                while( toBeRemoved != curNode ){
                    sumToBeRemoved += toBeRemoved.val ;
                    toBeRemoved = toBeRemoved.next ;
                    map.remove(sumToBeRemoved) ;
                }
                stNode.next = toBeRemoved.next ;
            }else{
                map.put(sum,curNode) ;
            }
            curNode = curNode.next ;
        }
        return resNode.next ;
    }
}
