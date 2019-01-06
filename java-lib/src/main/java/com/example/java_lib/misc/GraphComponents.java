package com.example.java_lib.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.hackerrank.com/contests/cs-dsa-01/challenges/components-in-graph
//Refer to GraphUnDirected class implementation before this

/*
There are  values to represent nodes in a graph. They are divided into two sets  and . Each set has exactly  values. Set  is represent by .  can contain any value between  to (inclusive). Set  is represented by .  can contain any value between  to (inclusive). Same value can be chosen any number of times.

Here  represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

Note Single nodes should not be considered in the answer.

For more clarity look at the following figure.

Alt text

For the above graph smallest connected component is 7 and largest connected component is 17.

Input Format

First line contains an integer .
Each of the next  lines contain two space-separated integers,  line contains  and .

Constraints

Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input

5
1 6
2 7
3 8
4 9
2 6
Sample Output

2 4
Explanation

The number of vertices in the smallest connected component in the graph is  i.e. either  or .
The number of vertices in the largest connected component in the graph is  i.e. .
 */
public class GraphComponents {
    HashMap<Integer, LinkedList<Integer>> adjListMap;

    GraphComponents(){
        adjListMap = new HashMap<>();
    }

    // Adds an edge to an undirected graph
    void addEdge( int src, int dest) {
        LinkedList<Integer> list = adjListMap.get(src);
        if (null == list){
            list = new LinkedList<>();
        }
        list.add(dest);
        adjListMap.put(src, list);

        // Since graph is undirected, add an edge from dest
        // to src also
        list = adjListMap.get(dest);
        if (null == list){
            list = new LinkedList<>();
        }
        list.add(src);
        adjListMap.put(dest, list);
    }


    static int DFSUtil(GraphComponents g, int v, HashMap <Integer, Boolean>  visited) {
        int count = 1;
        // Mark the current node as visited and print it
        visited.put(v, true);

        System.out.print(v+" ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : g.adjListMap.get(v)) {
            if(!visited.get(x))
                count += DFSUtil(g, x, visited);
        }
        return count;
    }


    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {

        int[] result = new int[2];
        result[0]=0;
        result[1]=0;

        GraphComponents g = new GraphComponents();
        for (int i = 0; i<gb.length; i++){
            g.addEdge(gb[i][0], gb[i][1]);
        }

        System.out.println("Adjacency Matrix: " + g.adjListMap.toString());

        // Mark all the vertices as not visited
        HashMap <Integer, Boolean> visited = new HashMap<>();
        g.adjListMap.keySet().stream().forEach(v -> visited.put(v, false));

        g.adjListMap.keySet().stream().forEach(v -> {
            if(!visited.get(v)) {
                // print all reachable vertices
                // from v
                int val = DFSUtil(g, v,visited);
                if (result[1] ==0 || val > result[1]){
                    result[1] = val;
                }
                if (result[0] == 0 || val <result[0]){
                    result[0] = val;
                }

                System.out.println("count:" + val);
                System.out.println();
            }

        });

        return result;
    }




    private static final Scanner scanner = new Scanner(System.in);

    // Driver program to test above
    public static void main(String[] args){
        /*
        Sample Input:
5
1 6
2 7
3 8
4 9
2 6
         */

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);
        System.out.println("final result:: smallest: " + result[0] + ", largest: " + result[1]);

    }



}
