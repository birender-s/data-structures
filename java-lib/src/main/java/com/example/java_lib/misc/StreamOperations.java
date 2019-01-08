package com.example.java_lib.misc;

import java.util.Arrays;
import java.util.List;

public class StreamOperations {

    public static void main(String[] args){

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("bbb");
//        list.add("d");
//        list.add("cccc");
////
////        list = list.stream().filter(s -> s.length()>2).collect(Collectors.toList());
//        System.out.println(list);

//        //The call to the map() method of the Stream interface is a non-terminal operation.
//        // It merely sets a lambda expression on the stream which converts each element to lowercase.
//        //The call to the count() method is a terminal operation. This call starts the iteration internally,
//        //which will result in each element being converted to lowercase and then counted.
//        long count = list.stream()
//                .map( (val) -> val.toLowerCase() )    //map converts an element to another object
//                .count();
//
//        System.out.println(list);

        //map String to Integer
        List<String> strList = Arrays.asList("2", "4", "1", "-2");
        int sum = strList.stream().mapToInt(i -> Integer.parseInt(i)).sum();
        System.out.println("sum of ints: " + sum);


//        //FILTERs - If the element is to be included in the resulting Stream, the Predicate should return true.
//        List<String> s = list.stream()
//                .filter( val -> val.length() >2 )   //exclude small strings below 3 length
//                .collect(Collectors.toList());      //collect the output and convert streams to a List
//        System.out.println(s);


//        //FlatMaps - maps a single element into multiple elements
//        // example that flatmaps a List of strings to the words in each string
//        List<String> stringList = new ArrayList<String>();
//
//        stringList.add("One flew over the cuckoo's nest");
//        stringList.add("To kill a muckingbird");
//        stringList.add("Gone with the wind");
//
//        stringList.stream().flatMap(s -> Stream.of(s.split(" ")))
//                            .forEach(System.out::println); //terminal operation, to trigger the internal iteration,
//                                                           // and thus flat map operation


//        //max - largets element from stream
//        String largest = list.stream()
//                .max( (val1, val2) -> val1.compareTo(val2))
//                .get();
//        System.out.println("max stream element: " + largest);


//        //REDUCE - reduce all elements in the stream to a single element.
//        List<String> stringList = new ArrayList<String>();
//        stringList.add("One flew over the cuckoo's nest.");
//        stringList.add("To kill a muckingbird.");
//        stringList.add("Gone with the wind.");
//
//        Optional<String> reduced = stringList.stream().reduce((value, combinedValue) -> combinedValue + " " + value);
//        System.out.println(reduced.get()); //=>> Gone with the wind + To kill a muckingbird + One flew over the cuckoo's nest


//        List<Integer> intList = Arrays.asList(1, -2, 3, 5, 9);
//        Integer sum = intList.stream().reduce(0, (i1, i2) -> i1+i2);
//        System.out.println("Sum of Ints: " + sum);

//        List<Integer> listInt = Arrays.asList(10,20,30,40,50);
//        List<Integer> listInt2 = listInt.stream()
//                          .map( val -> val*2).filter(val -> val>30 && val<80).collect(Collectors.toList());
//        System.out.println(listInt2);       // =>>  [40, 60]
//
//
//        //Method references (in lambda)
////        listInt.forEach(v1 -> System.out.print(v1));  //option 1
//        listInt.forEach(System.out::print);             //Method Reference - no need of param


        //Sum of Double of Integers
        List<Integer> arrayList = Arrays.asList(1, 1, 5, 4, 3, 3, 5, 6, 7, 2, 7, 6, 2);
        System.out.println("Sum of Double of Integers: "
                + arrayList.stream().filter(v -> v%2 ==0).mapToInt(i -> i*2).sum());

    }
}
