package com.example.java_lib.misc;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FormatStringPuzzle {
    public static void main(String[] args) {
        String str = "Python Is Truly Interesting Programming Language";

        String[] strArray = str.split(" ");
//        Arrays.stream(strArray).forEach(System.out::println);

        System.out.println(IntStream.range(0, strArray.length)
                .mapToObj(i -> {
                    if (i % 2 != 0) { //even position
                        return Arrays.stream(strArray[i].split(""))
                                .map(v -> {
                                    if (v.matches("[AEIOU]")){
                                        return "X";
                                    } else if (v.matches("[aeiou]")){
                                        return "x";
                                    }
                                    else{
                                        return v;
                                    }
                                })
                                .collect(Collectors.joining());
                    } else {    //odd position
                        String[] splitStr = strArray[i].split("");
                        StringBuffer evenPos = new StringBuffer();
                        StringBuffer oddPos = new StringBuffer();
                        for (int j=0;j<splitStr.length;j++){
                            if (j%2 == 0){
                                evenPos.append(splitStr[j]);
                            }else{
                                oddPos.append(splitStr[j]);
                            }
                        }
                        evenPos.reverse();
                        return oddPos.append(evenPos).toString();
                    }
                }
        ).collect(Collectors.joining(" ")) );

    }
}
