package com.example.java_lib.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming Example
 * https://www.techiedelight.com/longest-common-subsequence/
 */
public class LongestCommonSequenceLength {

    // Function to find length of Longest Common Subsequence of substring
    // X[0..m-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y, int m, int n,
                                Map<String, Integer> lookup)
    {
        System.out.println("\nLCSLength(" + X + ", " + Y + ", " + m +", " + n + ", " + lookup.toString() + ")");
//        printMap(lookup);

        //Base cases:
        if (m == 0 || n == 0)       // return if we have reached the end of either string
            return 0;

        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;
        System.out.println("\nkey: " + key);

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                System.out.println("match:  X.charAt(m - 1) == Y.charAt(n - 1) " + Y.charAt(n - 1));
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);

            }
            else {

                System.out.println(X.charAt(m - 1) + " don't match: " + Y.charAt(n - 1) );

                // else if last character of X and Y don't match
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n-1, lookup),
                        LCSLength(X, Y, m-1, n, lookup)));
            }
        }

        System.out.println("returning lookup.get(key):: key:" + key + ", val: " + lookup.get(key));
        // return the subproblem solution from the map
        return lookup.get(key);
    }


    // main function
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.print("The length of LCS is "
                + LCSLength(X, Y, X.length(), Y.length(), lookup));
    }
}
