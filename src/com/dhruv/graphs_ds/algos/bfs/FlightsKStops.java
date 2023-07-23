package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FlightsKStops {
    public static void main(String[] args) {

        int n = 4; int[][]flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int  src = 0, dst = 3, k = 1 ;
        int ans = findCheapestPrice(n,flights,src,dst,k);
        System.out.println(ans);

    }
    static public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = makeGraph(flights,n);
        boolean []visited = new boolean[n] ;
        PriorityQueue<Pair> mnh = new PriorityQueue<>() ;
        mnh.add(new Pair(src,0,0,0));
        int prc = -1 ;
        while( !mnh.isEmpty() ){
//             r m* w a*
            Pair rmv = mnh.remove() ;
            if( rmv.vtx == dst ){
//                 do some work
                prc = rmv.csf;
                break ;
            }
            if( rmv.stops > k ){
                continue ;
            }
            if( visited[rmv.vtx] == true ){
                continue ;
            }
            visited[rmv.vtx] = true ;
//             a*
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    mnh.add( new Pair(e.nbr,e.wt,rmv.csf + e.wt,rmv.stops+1) );
                }
            }
        }
        return prc ;
    }
    static ArrayList<Edge>[] makeGraph(int[][] flights, int n){
        ArrayList<Edge>[] graph = new ArrayList[n] ;
        for( int i = 0; i<graph.length ; i++ ){
            graph[i] = new ArrayList<>();
        }
        for( int i = 0 ; i<flights.length ; i++ ){
            graph[flights[i][0]].add(new Edge(flights[i][0],flights[i][1],flights[i][2]));
        }
        return graph ;
    }
    static class Edge{
        int vtx ;
        int nbr ;
        int wt ;
        Edge(int vtx, int nbr, int wt){
            this.vtx = vtx ;
            this.nbr = nbr ;
            this.wt = wt ;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vtx ;
        int cost ;
        int csf ;
        int stops ;

        Pair(int vtx, int cost ,int csf, int stops ){
            this.vtx = vtx ;
            this.cost = cost ;
            this.csf = csf ;
            this.stops = stops ;
        }
        @Override
        public int compareTo(Pair o){
            return this.cost-o.cost ;
        }
    }
}
