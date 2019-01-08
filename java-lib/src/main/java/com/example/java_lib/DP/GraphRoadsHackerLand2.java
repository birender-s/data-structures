package com.example.java_lib.DP;

import java.io.IOException;
import java.math.BigInteger;
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
public class GraphRoadsHackerLand2 {
    BigInteger [][] pathMatrix;

    public BigInteger getPathMatrix(int n, int[][] roads){
        long start = System.currentTimeMillis();
        System.out.println("Time1: " + start);
        pathMatrix = new BigInteger[n+1][n+1];
        for (int i = 0; i < pathMatrix.length; i++) {
            for (int j = 0; j < pathMatrix.length; j++) {
                pathMatrix[i][j] = BigInteger.ZERO;
            }
        }
        long newTime = System.currentTimeMillis();
        System.out.println("Time2: " + (newTime - start));
        start = newTime;


        for (int i=0; i<roads.length; i++){
            //if previous value is greater than new one
            if ( (pathMatrix[roads[i][1]][roads[i][0]] == BigInteger.ZERO)
                    || (1 == (pathMatrix[roads[i][1]][roads[i][0]]).compareTo(BigInteger.valueOf(2).pow(roads[i][2])) )) {
                BigInteger b = BigInteger.valueOf(2).pow(roads[i][2]); //(int)Math.pow(2,roads[i][2]);
                pathMatrix[roads[i][1]][roads[i][0]] = pathMatrix[roads[i][0]][roads[i][1]] = BigInteger.valueOf(2).pow(roads[i][2]);
            }
        }
        newTime = System.currentTimeMillis();
        System.out.println("Time3: " + (newTime - start));
        start = newTime;

        //find and update shortest path
        for (int k=0; k<pathMatrix.length; k++) {   //k is intermediate route
            for (int i = 0; i < pathMatrix.length; i++) {   //row
                for (int j = 0; j < pathMatrix.length; j++) {   //col
                    //Note: this is the check for shortest path
                    if ( 1 == (pathMatrix[i][k].compareTo(BigInteger.valueOf(0)) ) && (1 == pathMatrix[k][j].compareTo(BigInteger.valueOf(0))) )
                    pathMatrix[i][j] = (1 == pathMatrix[i][j].compareTo(BigInteger.ZERO)) ? pathMatrix[i][j].min(pathMatrix[i][k].add(pathMatrix[k][j]))
                                        : (pathMatrix[i][k].add(pathMatrix[k][j]));
                }
            }
        }

        newTime = System.currentTimeMillis();
        System.out.println("Time4: " + (newTime - start));
        start = newTime;


        //now get the sum
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < pathMatrix.length; i++) {   //row
            for (int j = 0; j < pathMatrix.length; j++) {   //col
//                System.out.println("pathMatrix[" + i + "][" + j + "]: " + pathMatrix[i][j]);

                //Note: this is the check for shortest path
                if (i<j) {
                    sum = sum.add(pathMatrix[i][j]);
                }
            }
        }

        newTime = System.currentTimeMillis();
        System.out.println("Time5: " + (newTime - start));
        start = newTime;

        return sum;
        }


    /*
     * Complete the roadsInHackerland function below.
     */
    static String roadsInHackerland(int n, int[][] roads) {
        GraphRoadsHackerLand2 g = new GraphRoadsHackerLand2();
        BigInteger sum = g.getPathMatrix(n, roads);
        return sum.toString(2);
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
