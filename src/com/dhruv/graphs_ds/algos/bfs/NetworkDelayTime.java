package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
//        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2 ;
        int[][] times = {{1,2,1},{2,1,3}};
        int n = 2;
        int k = 2 ;
        int ans = networkDelayTime(times,n,k);
        System.out.println(ans);
    }
    static public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = makeGraph(times,n,k);
        int ansTime = 0 ;
        boolean[] visited = new boolean[n+1] ;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()) {
//            r m* w a*
            Pair rmv = pq.remove();
//            m*
            if( visited[rmv.vtx]==true ){
                continue;
            }
            visited[rmv.vtx] = true ;
//            w*
            ansTime = rmv.time;
//            a*
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    pq.add(new Pair(e.nbr,rmv.time+e.wt));
                }
            }
        }
        for( int i = 1 ;i< visited.length ; i++ ){
            if( visited[i] == false ){
                return -1 ;
            }
        }
        return ansTime ;
    }

    static ArrayList<Edge>[] makeGraph(int[][]times, int n , int k ){
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for( int i = 0 ; i< graph.length ;i++ ){
            graph[i] = new ArrayList<Edge>();
        }
        for( int row = 0 ; row<times.length ; row++ ){
            graph[times[row][0]].add( new Edge(times[row][0],times[row][1],times[row][2]));
//            graph[times[row][1]].add(new Edge(times[row][1],times[row][0],times[row][2]));

        }
        for( int i = 0 ; i< graph.length ; i++ ){
            System.out.print(i+" -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).nbr +" ");
            }
            System.out.println();
        }
        return graph ;
    }

    static class Edge{
        int vtx ;
        int nbr ;
        int wt ;

        public Edge(int vtx, int nbr, int wt) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vtx ;
        int time ;

        public Pair(int vtx, int time) {
            this.vtx = vtx;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            return this.time-o.time;
        }
    }
}
