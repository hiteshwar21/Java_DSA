package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
  1 --- 3
 /      |  \
0       |   5 --- 6
 \      |  /
  2 --- 4
*/
public class BFSandDFS {

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

        bfs(graph,V,new boolean[V]);
        dfs(graph, 0, new boolean[V]);
    }

    static void bfs(ArrayList<Edge>[] graph, int V, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        //assuming source is 0
        queue.add(0);

        while (!queue.isEmpty()){
            int curr = queue.remove();
            while (!visited[curr]){
                System.out.println(curr + " ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge edge = graph[curr].get(i);
                    queue.add(edge.dest);
                }
            }
        }
        System.out.println();
    }

    static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited){
        if(visited[curr]){
            return;
        }
        System.out.println(curr + " ");
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge edge = graph[curr].get(i);
            dfs(graph, edge.dest, visited);
        }
    }
}
