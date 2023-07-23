package com.dhruv.graphs_ds.algos.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Edge{
    int src ;
    int nbr ;
    int wt ;

    public Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }
}
class Pair{
    int vtx ;
    String psf ;
    int wsf ;

    public Pair(int vtx, String psf, int wsf) {
        this.vtx = vtx;
        this.psf = psf;
        this.wsf = wsf;
    }
}

public class Algo {
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
        graph[4].add(new Edge(4,5,2));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,2));
        graph[5].add(new Edge(5,6,6));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,6));

//        for( int i = 0 ; i< graph.length ; i++ ){
//            System.out.print(i+" -> ");
//            for (int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j).nbr +" ");
//            }
//            System.out.println();
//        }

        boolean[] visited = new boolean[vts];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,"0",0));
        while (!q.isEmpty()){
//            r m* w a*
            Pair rem = q.remove();

            if( visited[rem.vtx] == true ){
                continue;
            }
            visited[rem.vtx] = true ;

//            w
            System.out.println(rem.vtx +" via "+rem.psf+" @ "+rem.wsf);
//            a*
            for( Edge e: graph[rem.vtx] ){
                if( visited[e.nbr] == false ){
                    q.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wsf+e.wt ));
                }
            }
        }

    }
}
