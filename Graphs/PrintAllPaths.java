package Graphs;

import java.util.ArrayList;

public class PrintAllPaths {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        int tar = 5;
        boolean[] vis = new boolean[V];
        vis[src] = true;
        printAllPaths(graph, src, tar, ""+src, vis);
    }

    static void printAllPaths(ArrayList<Edge>[] graph, int src, int tar, String path, boolean[] vis){
        if(src == tar){
            System.out.println(path);
            return;
        }

        for (int i=0;i<graph[src].size();i++){
            Edge edge = graph[src].get(i);
            if(!vis[edge.dest]){
                vis[edge.dest] = true;
                printAllPaths(graph, edge.dest, tar, path+ "-> " + edge.dest, vis);
                vis[edge.dest] = false;
            }
        }
    }
}
