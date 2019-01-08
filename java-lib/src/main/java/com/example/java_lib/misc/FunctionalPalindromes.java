package com.example.java_lib.misc;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 https://www.hackerrank.com/contests/world-codesprint-6/challenges/functional-palindromes/problem

 5 test pass, 2 timeouts and many fails
 */
public class FunctionalPalindromes {


    // Complete the solve function below.
    static int[] solve(String s, int[] queries) {

        int[] result = new int[queries.length];
        ArrayList <String> list = populatePalindromesInList(s);

        for (int i=0; i<queries.length; i++){
            result[i] = calculate(list, queries[i]-1).intValue();
        }

        return result;
    }

    static HashMap<String, BigInteger> calcMap = new HashMap<>();

    static BigInteger calculate(ArrayList <String> list, int index){
        if (index >= list.size() || index <0)
            return BigInteger.valueOf(-1);

        String str = list.get(index);
        BigInteger result;

        if (null != calcMap.get(str))
            return calcMap.get(str);

        //now calculate
        long a = 100001;

        //TODO: move m outside as its a constant value
        BigInteger m = BigDecimal.valueOf(Math.pow(10,9) + 7).toBigInteger();
//        long val = 0;
        BigInteger sum = new BigInteger("0");
        char[] chrArry = list.get(index).toCharArray();
        int len = chrArry.length;

        for (int i=0; i< len; i++){
            BigInteger pow = BigInteger.valueOf(a).pow(len-i-1);
//            System.out.println("pow: " + pow);
            BigInteger valTmp =  pow.multiply(BigInteger.valueOf(chrArry[i]));
//            System.out.println("valTmp(" + i + "): " + valTmp);

            sum = sum.add(valTmp);
        }
            result = sum.mod(m);
        calcMap.put(str, result);
        return result;
    }

    static ArrayList <String> populatePalindromesInList(String str){
        ArrayList <String> list = new ArrayList<>();
        String[] strArray = str.split("");
        Arrays.stream(strArray).forEach(v -> list.add(v));

        for (int i=2;i <= str.length(); i++) {
            ArrayList <String> listTemp = getPalindromes(str, i);
            if (null != listTemp) {
                list.addAll(listTemp);
            }
        }

        list.sort(Comparator.naturalOrder());
        return list;
    }

    static HashMap<String, Boolean> palindromeMap = new HashMap<>();

    static ArrayList<String> getPalindromes(String str, int len){
        if (null == str || str.length() == 0)
            return null;

        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i+len <= str.length();i++){
            String subStr = str.substring(i, i+len);

            if (null != palindromeMap.get(subStr)){
                if (palindromeMap.get(subStr) == true){
                    list.add(subStr);
                }
            }else if(isPalindrome(subStr)) {
                palindromeMap.put(subStr, true);
                list.add(subStr);
            } else {
                palindromeMap.put(subStr, false);
            }
        }
        return list;
    }

    static boolean isPalindrome(String str){
        if (null == str)
            return false;

        boolean response = true;

        int len = str.length()/2;
        for (int i=0; i<len;i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        String s = scanner.nextLine();
//        String s = "abcba";


        int[] queries = new int[q];

        for (int queriesItr = 0; queriesItr < q; queriesItr++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[queriesItr] = queriesItem;
        }

        int[] result = solve(s, queries);

        for (int i=0; i<result.length; i++)
            System.out.println("result[" + i + "]: " + result[i]);

//
//        for (int resultItr = 0; resultItr < result.length; resultItr++) {
//            bufferedWriter.write(String.valueOf(result[resultItr]));
//
//            if (resultItr != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

}
