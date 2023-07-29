package com.stack;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input){
        if(input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for(Character ch: input.toCharArray())
            stack.push(ch);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
