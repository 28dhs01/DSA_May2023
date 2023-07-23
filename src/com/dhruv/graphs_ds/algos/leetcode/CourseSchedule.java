package com.dhruv.graphs_ds.algos.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
//        int courses = 3 ;
//        int[][] prerequisites = {{1,0},{2,1},{0,2}};
        int courses = 20 ;
         int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}} ;
        boolean ans = canFinish(courses,prerequisites);
        System.out.println(ans);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Edge> [] graph = new ArrayList[numCourses] ;
        for( int i = 0 ; i<graph.length; i++ ){
            graph[i] = new ArrayList<>() ;
        }
        for( int [] ar: prerequisites ){
            int nbr = ar[0] ;
            int src = ar[1] ;
            graph[src].add(new Edge(src,nbr));
            graph[nbr].add(new Edge(nbr,src));
        }
        int curSrc = 0 ;
        for( List<Edge> list: graph ){
            System.out.print(curSrc +"->");
            for( Edge ed: list ){
                System.out.print(ed.nbr+",");
            }
            System.out.println();
            curSrc++ ;
        }
        boolean [] visited = new boolean[numCourses];
        for( int v = 0 ; v<numCourses ; v++ ){
            if(visited[v] == false ){
                boolean cyclic = bfs(graph,v,visited) ;
                if(cyclic){
                    System.out.println(v);
                    return false ;
                }
            }
        }
        return true ;
    }
    static boolean bfs(List<Edge>[] graph, int src, boolean[]visited ){
        Queue<Integer> q = new ArrayDeque<>() ;
        q.add(src) ;
        while( !q.isEmpty() ){
//             r m* w a*
            int peek = q.peek() ;
            q.poll() ;
            if( visited[peek] == true ){
                return true ;
            }
            visited[peek] = true ;
            for( Edge e: graph[peek] ){
                if( visited[e.nbr] == false ){
                    q.add(e.nbr) ;
                }
            }
        }
        return false ;
    }
    static class Edge{
        int src ;
        int nbr ;
        Edge(int src, int nbr){
            this.src = src ;
            this.nbr = nbr ;
        }
    }
}
