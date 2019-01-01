package com.example.java_lib.misc;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDoubleofEvenNumbers {
    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 1, 5, 4, 3, 3, 5, 6, 7, 2, 7, 6, 2));

        System.out.print(arrayList.stream()
                .filter(v -> v %2 == 0)
                .mapToInt(v -> v*2)
                .sum());
    }

}
