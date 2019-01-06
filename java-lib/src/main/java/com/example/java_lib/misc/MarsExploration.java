package com.example.java_lib.misc;

/**
 * https://www.hackerrank.com/contests/cs-dsa-02/challenges/mars-exploration
 *
 */
public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int count = 0;
        // String [] strArry = s.split("SOS")
        for(int i=0; i<s.length(); i+=3){
            count += verifySOS(s.substring(i,i+3));
        }
        return count;
    }

    private static int verifySOS(String str){
        int count =0;
        if ('S' != str.charAt(0))
            count++;
        if ('O' != str.charAt(1))
            count++;
        if ('S' != str.charAt(2))
            count++;

        return count;
    }

    public static void main (String []args){
        System.out.println("result: " + marsExploration("SOSSPSSQSSOR"));
    }
}
