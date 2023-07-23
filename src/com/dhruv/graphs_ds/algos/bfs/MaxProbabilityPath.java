package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProbabilityPath {
    public static void main(String[] args) {
        int n = 3; int[][] edges = {{0,1},{1,2},{0,2}}; double[] succProb = {0.5,0.5,0.3}; int start = 0;int end = 2;
        double mxProb = maxProbability(n,edges,succProb,start,end);
        System.out.println(mxProb);
    }
    static public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double resProb = 0.0 ;
        ArrayList<Edge>[]graph = makeGraph(edges, n, succProb);
        PriorityQueue<Pair> mxh = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        mxh.add(new Pair( start,1 ));
        while( !mxh.isEmpty() ){
//            r m* w a*
            Pair rmv = mxh.remove();
            if( visited[rmv.vtx] ){
//                do some work
                continue;
            }
            if( rmv.vtx == end ){
                resProb = rmv.prob ;
                break;
            }
            visited[rmv.vtx] = true ;
//            a*
            for( Edge e: graph[rmv.vtx] ){
                if( visited[e.nbr] == false ){
                    System.out.println(rmv.prob*e.prob);
                    mxh.add(new Pair(e.nbr,rmv.prob*e.prob));
                }
            }
        }
        return resProb;
    }
    static ArrayList<Edge>[] makeGraph(int[][]edges, int n,double[]succProb){
        ArrayList<Edge> [] graph = new ArrayList[n] ;
        for( int i = 0 ; i< graph.length ; i++ ){
            graph[i] = new ArrayList<Edge>();
        }
        for( int row = 0 ; row < edges.length ; row++ ){
            graph[edges[row][0]].add(new Edge(edges[row][0],edges[row][1],succProb[row]));
            graph[edges[row][1]].add(new Edge(edges[row][1],edges[row][0],succProb[row]));
        }

//        for( int i = 0 ; i< graph.length ; i++ ){
//            System.out.print(i+" -> ");
//            for (int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j).nbr +"/"+graph[i].get(j).prob+" ");
//            }
//            System.out.println();
//        }
        return graph;
    }
    static class Edge{
        int vtx ;
        int nbr ;
        double prob ;

        public Edge(int vtx, int nbr, double prob) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.prob = prob;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vtx ;
        double prob ;

        public Pair(int vtx, double prob) {
            this.vtx = vtx;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair o) {
//            if( this.prob - o.prob > 1 ){
//                return 1 ;
//            }
//            else if( this.prob - o.prob < 1 ){
//                return -1 ;
//            }
//            return 0 ;
//            double v = (o.prob - this.prob);
//            return  (int)(v) ;
            return Double.compare(o.prob,this.prob);

        }
    }

}
