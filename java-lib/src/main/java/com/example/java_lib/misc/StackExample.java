package com.example.java_lib.misc;

import java.util.Stack;

/**
 * https://www.journaldev.com/13401/java-stack
 */
public class StackExample {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack.pop() result: " + stack.pop());
        stack.pop();
        stack.push(5);

        stack.stream().forEach(v -> System.out.println(v));

    }
}
