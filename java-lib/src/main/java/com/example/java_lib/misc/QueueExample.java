package com.example.java_lib.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/queue-interface-java/
 */
public class QueueExample {

    public static void main(String[] args){

        //Note: Queue is abstract class, implements LinkedList in below example
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove(); //removes front element 1
        queue.add(4);

        // To view the head of queue
        int head = queue.peek();
        System.out.println("head of queue-" + head);

        // Rest all methods of collection interface,
        // Like size and contains can be used with this
        // implementation.
        int size = queue.size();
        System.out.println("Size of queue-" + size);

        queue.stream().forEach(v -> System.out.println(v));
    }
}
