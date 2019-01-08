package com.example.java_lib.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/*
The question is "Given an array of integers, find and print the unique element."

For example, if the input is:

1,1,5,4,3,3,5,6,7,2,7,6,2

Output should be:

4
 */

public class LonelyInteger {
    public static void main (String[] args){
        List<Integer> arrayList = Arrays.asList(1,1,5,4,3,3,5,6,7,2,7,6,2);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //approach 1:
//        arrayList.stream()
//                .forEach(val -> {
//                    if (null == map.get(val))
//                        map.put(val, 1);
//                    else
//                        map.put(val, (map.get(val))+1);
//                      });
//
//        System.out.println("output:" + map.entrySet().stream()
//                .filter(val -> val.getValue() == 1).collect(Collectors.toList()).get(0).getKey());

//        //approach 2: uses XOR operator in reducer
//        System.out.println("output:" + arrayList.stream().reduce( (v1, v2) -> v1^v2 ).orElse(0));

        //approach 3: set (removes duplicates)
        Set <Integer> set = new HashSet<Integer>(arrayList.stream().collect(Collectors.toList()));
        System.out.println("output:" + set.size());




    }
}
