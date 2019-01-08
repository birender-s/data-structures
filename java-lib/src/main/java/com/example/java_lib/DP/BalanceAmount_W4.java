package com.example.java_lib.DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
John is travelling in a bus. While buying the ticket, he realizes that he doesn’t have the exact amount.  So he requests the conductor to return the balance.
Given the balance amount to be returned and the valid denominations, write a program to print the number of ways in which the balance amount can be
returned assuming the conductor has infinite number of such valid denominations.

Input format:

The first line gives the balance amount to be returned. The second line gives the valid denominations, each denomination separated by a comma.
Read the input from standard input.

Output format:

Print the number of ways in which balance can be returned to the standard output.

Sample Input
10
2,3,5,10

Sample Output	Explanation
5	            The possible ways in which balance can be returned are: (2 2 2 2 2),(2 2 3 3),(2 3 5),(5 5),(10) Hence the output is 5.
 */


//Reference: https://www.youtube.com/watch?v=sn0DWI-JdNA#action=share
public class BalanceAmount_W4 {

    public static void main(String []args){
        int numWays = 0;
        String amount = "10";
        String strDenominations = "2,3,5,10";

        Integer intAmount = Integer.parseInt(amount);
        String [] denoms = strDenominations.split(",");
        List<Integer> list = Arrays.stream(denoms).map(Integer::parseInt).collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());
        System.out.println("amount: "+ intAmount);
        System.out.println(list.toString());

        System.out.println("num ways: " + getNumWays(intAmount, list, new HashMap<>()));
    }

    public static Integer getNumWays(int amount, List<Integer> denoms, HashMap<String, Integer> map) {
        return getNumWays(amount, denoms, 0, map);
    }


    public static Integer getNumWays(int amount, List<Integer> denoms, int index, HashMap<String, Integer> map){
//        System.out.println("map: " + map.toString());

        //Base cases:
        if (0 == amount)
            return 1;   //IMPORTANT : how many ways we can make 0 balance amount irrespective of coins left, its 1
        if (index >= denoms.size())
            return 0;

        String mapKey = amount + "_" + (index);
//        System.out.println("checking key: " + mapKey);
        if (map.containsKey(mapKey)) {
//            System.out.println("key found, key: " + mapKey + ", val: " + map.get(mapKey));
            return map.get(mapKey);
        }

        int numWays = 0;
        int amountWithCoin = 0;

        while (amountWithCoin <= amount){
            int balanceAmount = amount - amountWithCoin;
            numWays += getNumWays(balanceAmount, denoms, index+1, map); //very first time, consider current index item 0 times (hence passes full balance amount)
            // , next time 1 current item, next time  2 current item and so on
            amountWithCoin += denoms.get(index);    //current item value
        }
        map.put(mapKey, numWays);
        return numWays;
    }

}
