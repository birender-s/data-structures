package com.example.java_lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.techiedelight.com/longest-common-subsequence-finding-lcs/

//INCOMPLETE
public class LongestCommonSequence {

    // Function to find length of Longest Common Subsequence of substring
    // X[0..m-1] and Y[0..n-1]
    public static ArrayList<String> LCS_String(String X, String Y, int m, int n, Map<String, ArrayList<String>> lookup)
    {
        System.out.println("\nLCS_String(" + X + ", " + Y + ", " + m +", " + n + ", " + lookup.toString() + ")");
//        printMap(lookup);
        // return if we have reached the end of either string
        if (m == 0 || n == 0)
            return null;

        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;
        System.out.println("\nkey: " + key);

        // if sub-problem is seen for the first time, solve it and store its result in a map
        if (!lookup.containsKey(key))
        {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                System.out.println("match:  X.charAt(m - 1) == Y.charAt(n - 1) " + Y.charAt(n - 1));
//                lookup.put(key, LCS_String(X, Y, m - 1, n - 1, lookup) + X.charAt(m - 1));
                insertToMap(key, appendToListItems(LCS_String(X, Y, m - 1, n - 1, lookup), X.charAt(m - 1)), lookup);
            }
            else {
                System.out.println(X.charAt(m - 1) + " don't match: " + Y.charAt(n - 1) );

                // else if last character of X and Y don't match
                ArrayList<String> firstLcs = LCS_String(X, Y, m, n-1, lookup);
                ArrayList<String> secondLcs = LCS_String(X, Y, m-1, n, lookup);

                updateMap(lookup, key, firstLcs, secondLcs);
//                lookup.put(key, firstLcs.length() > secondLcs.length() ? firstLcs : secondLcs);
            }
        }

        System.out.println("returning lookup.get(key):: key:" + key + ", val: " + lookup.get(key));
        // return the subproblem solution from the map
        return lookup.get(key);
    }

    private static void updateMap(Map<String, ArrayList<String>> lookup, String key, ArrayList<String> firstLcs, ArrayList<String> secondLcs) {
        if ( (null != firstLcs && firstLcs.size() >0) && (null != secondLcs && secondLcs.size() >0) ) {
            if (firstLcs.get(0).length() > secondLcs.get(0).length()) {  //assuming all entries in an arraylist have same length
//                    lookup.put(key, firstLcs);
                insertToMap(key, firstLcs, lookup);
            } else if (firstLcs.get(0).length() == secondLcs.get(0).length()) {
                System.out.println("firstLcs.length() == secondLcs.length():: firstLcs: " + firstLcs + ", secondLcs: " + secondLcs);
                insertToMap(key, firstLcs, lookup);
                insertToMap(key, secondLcs, lookup);
            } else {
//                    lookup.put(key, secondLcs);
                insertToMap(key, secondLcs, lookup);
            }
        } else {        //one of the list is empty
            if (null != firstLcs && firstLcs.size() >0){
                insertToMap(key, firstLcs, lookup);
            } else if (null != secondLcs && secondLcs.size() >0){
                insertToMap(key, secondLcs, lookup);
            }
        }
    }

    private static ArrayList<String>  appendToListItems(ArrayList<String> list, char chr){
        if (list != null && list.size() > 0)
            list.stream().forEach(v -> v += chr);

        return list;
    }

    private static void insertToMap(String key, ArrayList<String> list, Map<String, ArrayList<String>> lookup){
        if (null == list)
            return;

        ArrayList<String> listTmp = lookup.get(key);
        if (null == listTmp) {
            lookup.put(key, list);
        }else {
            list.stream().forEach(v -> {if (!listTmp.contains(v)) {listTmp.add(v);} });
            lookup.put(key, listTmp);
        }
    }

    // main function
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";

        // create a map to store solutions of subproblems
        Map<String, ArrayList<String>> lookup = new HashMap<>();

        System.out.print("The length of LCS is "
                + LCS_String(X, Y, X.length(), Y.length(), lookup));
    }
}
