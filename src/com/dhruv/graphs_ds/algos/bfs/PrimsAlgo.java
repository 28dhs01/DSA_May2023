package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        int vts = 7 ;
        ArrayList<Edge>[] graph = new ArrayList[vts];
        for( int i = 0 ; i< graph.length; i++ ){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));

        boolean []visited = new boolean[vts];
//        r m* w a*
        PriorityQueue<Pair> mnh = new PriorityQueue<>();
        mnh.add(new Pair(0,-1,0));
        while ( !mnh.isEmpty() ){
            Pair rmv = mnh.remove( );
            if( visited[rmv.vtx] == true ){
                continue;
            }
            visited[rmv.vtx] = true ;
//            w
            if( rmv.aqVtx != -1 ){
                System.out.println(rmv.vtx+"-"+ rmv.aqVtx+"@"+rmv.curWt);
            }
//            a*
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    mnh.add(new Pair(e.nbr,rmv.vtx,e.wt));
                }
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        int vtx ;
        int aqVtx ;
        int curWt ;

        public Pair(int vtx, int aqVtx, int curWt) {
            this.vtx = vtx;
            this.aqVtx = aqVtx;
            this.curWt = curWt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.curWt-o.curWt;
        }
    }

}
