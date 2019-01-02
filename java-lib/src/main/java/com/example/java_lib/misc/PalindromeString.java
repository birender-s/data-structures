package com.example.java_lib.misc;


public class PalindromeString {

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


    public static void main (String []args){
        System.out.println(isPalindrome("abc"));
    }
}
