package com.dhruv.graphs_ds.algos.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge{
        int vtx ;
        int nbr ;
        Edge(int vtx, int nbr){
            this.vtx = vtx ;
            this.nbr = nbr ;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter your entries");
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here

        Stack<Integer> stack = new Stack<>();
        boolean[]visited = new boolean[vtces];
        for (int v = 0; v < visited.length; v++) {
            if(!visited[v]){
                topologicalSort(graph,v,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            int peekElement = stack.peek();
            stack.pop();
            System.out.println(peekElement);
        }
    }
    static void topologicalSort(ArrayList<Edge>[]graph, int src, boolean[]visited, Stack<Integer> stack ){
        visited[src] = true ;
        for(Edge e: graph[src]){
            if(!visited[e.nbr]){
                topologicalSort(graph,e.nbr,visited,stack);
            }
        }
        stack.push(src);
    }

}
