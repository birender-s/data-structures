package com.example.java_lib.DP;

import java.io.IOException;
import java.util.Scanner;

/**
 * Shortest Path Algo, extension of Warshall's Algo (GraphWarshallAlgo)
 * https://www.hackerrank.com/contests/cs-dsa-02/challenges/johnland
 *
 * John lives in HackerLand, a country with  cities and  bidirectional roads. Each of the roads has a distinct length, and each length is a power of two (i.e.,  raised to some exponent). It's possible for John to reach any city from any other city.

 Given a map of HackerLand, can you help John determine the sum of the minimum distances between each pair of cities? Print your answer in binary representation.

 Input Format

 The first line contains two space-seperated integers denoting  (the number of cities) and  (the number of roads),
 respectively. Each line  of the  subsequent lines contains the respective values of , , and  as
 three space-separated integers. These values define a bidirectional road between cities  and  having length .

 Find the sum of minimum distances of each pair of cities and print the answer in binary representation.

 Sample Input

 5 6
 1 3 5
 4 5 0
 2 1 3
 3 2 1
 4 3 4
 4 2 2
 Sample Output
 1000100
 */
public class GraphRoadsHackerLand {
    int [][] pathMatrix;

    public int getPathMatrix(int n, int[][] roads){
        pathMatrix = new int[n+1][n+1];

        for (int i=0; i<roads.length; i++){
            pathMatrix[roads[i][1]][roads[i][0]] = pathMatrix[roads[i][0]][roads[i][1]] = (int)Math.pow(2,roads[i][2]);
        }

        //find and update shortest path
        for (int k=0; k<pathMatrix.length; k++) {   //k is intermediate route
            for (int i = 0; i < pathMatrix.length; i++) {   //row
                for (int j = 0; j < pathMatrix.length; j++) {   //col
                    //Note: this is the check for shortest path
                    if ( (pathMatrix[i][k] > 0) && (pathMatrix[k][j] > 0) )
                    pathMatrix[i][j] = pathMatrix[i][j] > 0 ? Math.min(pathMatrix[i][j], pathMatrix[i][k] + pathMatrix[k][j])
                                        : (pathMatrix[i][k] + pathMatrix[k][j]);
                }
            }
        }

        //now get the sum
        int sum = 0;
        for (int i = 0; i < pathMatrix.length; i++) {   //row
            for (int j = 0; j < pathMatrix.length; j++) {   //col
//                System.out.println("pathMatrix[" + i + "][" + j + "]: " + pathMatrix[i][j]);

                //Note: this is the check for shortest path
                if (i<j) {
                    sum += pathMatrix[i][j];
                }
            }
        }
        return sum;
        }


    /*
     * Complete the roadsInHackerland function below.
     */
    static String roadsInHackerland(int n, int[][] roads) {
        GraphRoadsHackerLand g = new GraphRoadsHackerLand();
        int sum = g.getPathMatrix(n, roads);
        return Integer.toBinaryString(sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] roads = new int[m][3];

        for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
            String[] roadsRowItems = scanner.nextLine().split(" ");

            for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
                int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
                roads[roadsRowItr][roadsColumnItr] = roadsItem;
            }
        }

        String result = roadsInHackerland(n, roads);
        System.out.println("Result: " + result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }


}
