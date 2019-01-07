package com.example.java_lib.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search Algo - Print all reachable nodes from a given vertex (node)
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph
 */
public class GraphUndirectedBFS {
    HashMap <Integer, LinkedList<Integer>> adjMap;  //adjacency List Map

    public GraphUndirectedBFS(){
        adjMap = new HashMap<>();
    }

    public void addEdge(int src, int dest){
        LinkedList<Integer> list = adjMap.get(src);
        if (null == list)
            list = new LinkedList<>();

        list.add(dest);
        adjMap.put(src, list);

        //also add reverse since undirected graph
        list = adjMap.get(dest);
        if (null == list)
            list = new LinkedList<>();

        list.add(src);
        adjMap.put(dest, list);

    }

    //print all nodes reachable from this vertex
    public void printBfsList(int vertex){
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        //set all vertecies(nodes) as Not Visited
        adjMap.keySet().stream().forEach(v -> visited.put(v, false));

        q.add(vertex);
        System.out.print("BFS: ");

        printBfsHelper(q, visited);
    }

    private void printBfsHelper(Queue<Integer> q, HashMap<Integer, Boolean> visited){
        if (null == q || q.isEmpty())
            return;
//        System.out.print("\nQueue: ");
//        q.stream().forEach(v -> System.out.print(v + ", "));

//        System.out.println("\nVisited map: " + visited.toString());
//        q.stream().forEach(v -> System.out.print(v + ", "));

        Integer v = q.remove();
        System.out.print(v + ", ");
        visited.put(v, true);

        LinkedList<Integer> list = adjMap.get(v);

        list.stream().forEach(vrtx-> {
                                if (true != visited.get(vrtx) && !q.contains(vrtx)){
                                    q.add(vrtx);
                                }    });
        printBfsHelper(q, visited);
    }




    public static void main (String[] args){
        GraphUndirectedBFS g = new GraphUndirectedBFS();
//        graph.addEdge(1,3);
//        graph.addEdge(4,5);
//        graph.addEdge(2,1);
//        graph.addEdge(3,2);
//        graph.addEdge(4,3);
//        graph.addEdge(4,2);


//        graph.addEdge(1,2);
//        graph.addEdge(1,3);
//        graph.addEdge(2,4);
//        graph.addEdge(2,5);
//        graph.addEdge(3,1);
//        graph.addEdge(3,5);
//        graph.addEdge(4,2);
//        graph.addEdge(4,5);
//        graph.addEdge(4,6);
//        graph.addEdge(5,2);
//        graph.addEdge(5,3);
//        graph.addEdge(5,4);
//        graph.addEdge(5,6);
//        graph.addEdge(6,4);
//        graph.addEdge(6,5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printBfsList(2);
    }
}
