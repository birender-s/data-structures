package com.example.java_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NaturalNumbersList {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        String str = "11,5,19,2,8,3,4";     //another sample input  67,32,1
        String[] strArray = str.split(",");

        //sorted list
        List<Integer> list = Arrays.stream(strArray).map(Integer::valueOf).sorted().collect(Collectors.toList());
        System.out.println("Input List "+list);

        List<Integer> outList = new ArrayList<>();

        //get all possible lists
        for (int i=1; i<list.size(); i++) {
            naturalNumbers(list, list.size() - i, outList);
            Collections.reverse(outList);
            System.out.println("Output List " + i + ". = "+ outList);
            if (!outList.isEmpty()) {
                map.put(outList.size(), outList);       //new list of same size (key) will replace old, we do so to get first list element
            }
            outList = new ArrayList<>();        //clear list
        }

        if(!map.isEmpty()){
            Integer max=map.keySet().stream().max(Integer::compareTo).get();    //max key in map
            System.out.print(map.get(max).stream().map(v->v.toString()).collect(Collectors.joining(",")));
        }else{
            System.out.println("-1");                                           //not found
        }

    }

    // Greedy approach
    public static void naturalNumbers(List<Integer> inList, int index, List<Integer> outList) {
//        System.out.println("naturalNumbers() inList:"+inList + ", index:" + index + ", outList: " + outList);
        if (inList.isEmpty() || index < 0)
            return;

        int newIndex = populateList(inList, index, outList);

        if (-1 != newIndex){
            List<Integer> newInputList = new ArrayList<Integer>(inList.subList(0, newIndex));
            List<Integer> newInputList2 = new ArrayList<Integer>(outList);
            Collections.reverse(newInputList2);
            newInputList.addAll(newInputList2);
//            System.out.println("newInputList: " + newInputList);
            naturalNumbers(newInputList,newIndex+1, outList);
        }
    }

    public static int populateList(List<Integer> inList, int index, List<Integer> outList){
        for (int i = index-1; i >= 0; i--) {
//            System.out.println("for loop, i: " + i);
            for (int j = i-1; j >= 0; j--) {
                if (addPairIfExists( inList.get(i), inList.get(j), inList.get(index), outList)) {
                    return j;
                }
            }
        }
        return -1;

    }

    public static boolean addPairIfExists(Integer i, Integer j, Integer sumValue, List<Integer> updatedlist){
//        System.out.println("addPairIfExists() i:"+i + ", j:" + j + ", sumValue: " + sumValue + ", updatedlist: " + updatedlist);
        if (i + j == sumValue) {
            if(updatedlist.isEmpty()) {     //add only for first time
                updatedlist.add(sumValue);
                updatedlist.add(i);
            }
            updatedlist.add(j);             //add smaller element in pair
//            System.out.println("pair found");
            return true;
        }
//        System.out.println("pair NOT found");
        return false;

    }

}
