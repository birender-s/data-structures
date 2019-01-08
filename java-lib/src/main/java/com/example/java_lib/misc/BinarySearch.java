package com.example.java_lib.misc;

/**
 * Binary Search in sorted list
 */
public class BinarySearch {

    int [] list;
    public BinarySearch(int [] inputList){
        list = new int[inputList.length];

        for (int i = 0; i < inputList.length; i++) {
            list[i] = inputList[i];
        }
    }

    public int search(int item){
        return search(item, 0, list.length-1);
    }

    private int search(int item, int startIndx, int endIndx){
        int mid = (endIndx + startIndx)/2 ;

        //base case:
        if ( (startIndx == endIndx) || startIndx > endIndx)
            return -1;      //item not found

        if (list[mid] == item)
            return mid;

        if (list[mid] > item)
            return search(item, startIndx, mid);
        else
            return search(item, mid+1, endIndx);
    }

    public static void main(String[] args){
        int [] list  = new int[]{1,2,3,5,9, 13};

        BinarySearch bs = new BinarySearch(list);
        System.out.println("item found at index: "+ bs.search(11));


    }
}
