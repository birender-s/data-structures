package com.example.java_lib.DP;

import java.util.HashMap;
import java.util.Map;

/*
https://www.techiedelight.com/longest-common-substring-problem/
INCOMPLETE
 */
public class LongestCommonSubString {

    public static String LCSubStr(String X, String Y, int indxX, int indxY, Map<String, String> lookup){
        //base cases:
        if (indxX >= X.length() || indxY >= Y.length())
            return "";

        StringBuilder builder = new StringBuilder("");

        for (int i = indxY; i< X.length(); i++){
//            if (X.charAt(indxX) == Y.charAt(i))
//                builder.append(X.charAt(indxX));
//            else
//                LCSubStr(X,Y,++indxX, ++indxY)
//


        }

//        while (indxX < X.length() && indxY < Y.length()){
//            if X[indxX]
//
//        }

//        lookup.forEach(x,y -> x);
        return null;
    }

    public static void main(String [] args){
        String X = "ABCBDAB", Y = "BDCABA";
//        String X = "ABCB", Y = "BDC";
        // create a map to store solutions of subproblems
        Map<String, String> lookup = new HashMap<>();

        System.out.print("LC SUBSTRING: "
                + LCSubStr(X, Y, X.length(), Y.length(), lookup));
    }
}
