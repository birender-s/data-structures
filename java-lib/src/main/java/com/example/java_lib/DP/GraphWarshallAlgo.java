package com.example.java_lib.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://www.youtube.com/watch?v=uPHEJxB6Djw
 * https://www.youtube.com/watch?v=DCNDWRIAxcU
 *
 * Warshall's Algorithm (All Pair Shortest Path) to Find Path Matrix Example - For Directed Graph
 *
 */
public class GraphWarshallAlgo {
    HashMap<Character, LinkedList<Character>> adjListMap;

    boolean [][] pathMatrix;

    public GraphWarshallAlgo(){ adjListMap = new HashMap<>(); }

    // Adds an edge to an undirected graph
    void addEdge( Character src, Character dest) {
        LinkedList<Character> list = adjListMap.get(src);
        if (null == list){
            list = new LinkedList<>();
        }
        list.add(dest);
        adjListMap.put(src, list);
    }


    //https://www.youtube.com/watch?v=uPHEJxB6Djw
    public void getPathMatrix(){
        pathMatrix = new boolean[adjListMap.size()][adjListMap.size()];

        Character[] chArry = adjListMap.keySet().toArray(new Character[adjListMap.keySet().size()]);

        //set path matrix
        for (int i=0; i<adjListMap.size(); i++){
            for (int j=0; j<adjListMap.size(); j++){
                if (null != adjListMap.get(chArry[i]) && adjListMap.get(chArry[i]).contains(chArry[j])){
                    pathMatrix[i][j] = true;
                }
            }
        }

        //update for indirect paths
        for (int k=0; k<adjListMap.size(); k++){
            for (int i=0; i<adjListMap.size(); i++) {
                for (int j = 0; j < adjListMap.size(); j++) {
                    //Note: path reachable if OR returns true
                    pathMatrix[i][j] =  (pathMatrix[i][j]) || (pathMatrix[i][k] && pathMatrix[k][j]);
                }
            }
        }

        //Print path matrix...
        System.out.print("   ");
        Arrays.stream(chArry).forEach(v -> System.out.print(v + "  "));
        for (int i=0; i<adjListMap.size(); i++) {
            System.out.print("\n" + chArry[i] + "  ");
            for (int j = 0; j < adjListMap.size(); j++) {
                System.out.print(((pathMatrix[i][j] == true)? 1 : 0) + "  ");
            }
        }

    }

    public static void main (String [] args){
        GraphWarshallAlgo g = new GraphWarshallAlgo();
        g.addEdge('X', 'W');
        g.addEdge('Y', 'X');
        g.addEdge('Y', 'Z');
        g.addEdge('Y', 'W');
        g.addEdge('Z', 'X');
        g.addEdge('Z', 'W');
        g.addEdge('W', 'Z');

        g.getPathMatrix();


    }
}
