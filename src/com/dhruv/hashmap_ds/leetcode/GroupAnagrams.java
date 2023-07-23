package com.dhruv.hashmap_ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate"};
        List<List<String>> ansLst = groupAnagrams(strs);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outerLst = new ArrayList<>();
        ArrayList<HashMap<Character,Integer>> hmlst = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,ArrayList<String>> listMapping = new HashMap<>();
        for( String str: strs ){
            HashMap<Character,Integer> map = new HashMap<>();
            for( int i = 0 ; i<str.length() ; i++ ){
                char key = str.charAt(i);
                if( map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,1);
                }
            }
            if( !hmlst.contains(map) ){
                hmlst.add(map);
                ArrayList<String> strLst = new ArrayList<>() ;
                strLst.add(str);
                listMapping.put(map,strLst);
            }else{
                ArrayList<String> strLst = listMapping.get(map);
                strLst.add(str);
            }
//            System.out.println(hmlst);
//            System.out.println(map);
        }
        for( HashMap<Character,Integer>key : listMapping.keySet()){
            outerLst.add(listMapping.get(key));
        }
        System.out.println(outerLst);
        return outerLst ;
    }
}
