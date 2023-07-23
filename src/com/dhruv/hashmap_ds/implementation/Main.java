package com.dhruv.hashmap_ds.implementation;

import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",135);
        hm.put("China",200);
        hm.put("USA",30);
        hm.put("Russia",50);
        hm.put("Australia",15);
        System.out.println(hm);
        int ruPopulation = hm.get("Russia");
        System.out.println(ruPopulation);
        hm.put("India",175);
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Nigeria"));

        Set<String> set = hm.keySet();
        System.out.println(set);
        for (String key: set) {
            int val = hm.get(key);
            System.out.println(key+"->"+val);
        }
    }
}
