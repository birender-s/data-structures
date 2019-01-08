package com.example.java_lib.misc;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

public class ClimbingTheLeaderBoard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Set <Integer> scoresSet = new HashSet<>();
        for (int i=0;i<scores.length;i++)
            scoresSet.add(scores[i]);
        // System.out.println("scoresSet size: "+ scoresSet.size());

        List<Integer> marksList = scoresSet.stream().collect(Collectors.toList());
        marksList.sort(Comparator.reverseOrder());

        int [] aliceScores = new int[alice.length];

        for (int i=0;i<alice.length;i++)
            aliceScores[i] = getPosition(alice[i], marksList);

        return aliceScores;
    }

    static int getPosition(int myMarks, List<Integer> marksList){
        // System.out.println("getPosition");
        // marksList.int
        int i = marksList.indexOf(myMarks);
        if (i>0)
            return i+1;

        i=1;
        for (Integer mark: marksList){
            // System.out.println("setMarks: " + mark);
            if (myMarks >= mark)
                return i;
            i++;
        }
        return i;
    }

    static int binarySearch(Integer[] marksArry, int myMarks, int startIndx, int endIndx){
        int mid = marksArry.length/2;
        if (myMarks < marksArry[mid])
            return binarySearch(marksArry, myMarks, 0, mid);
        else
            return binarySearch(marksArry, myMarks, mid+1, marksArry.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int scoresCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] scores = new int[scoresCount];
//
//        String[] scoresItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < scoresCount; i++) {
//            int scoresItem = Integer.parseInt(scoresItems[i]);
//            scores[i] = scoresItem;
//        }
//
//        int aliceCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] alice = new int[aliceCount];
//
//        String[] aliceItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < aliceCount; i++) {
//            int aliceItem = Integer.parseInt(aliceItems[i]);
//            alice[i] = aliceItem;
//        }


//        int[] scores = new int[]();
//        int[] result = climbingLeaderboard(scores, alice);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
