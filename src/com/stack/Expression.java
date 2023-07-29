package com.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final String input;
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public Expression(String input) {
        this.input = input;
    }

    public boolean isBalanced(){
        if(input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for(Character ch: input.toCharArray()){
            if(isLeftBracket(ch))
                stack.push(ch);
            if(isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                var top = stack.pop();
                if(!bracketMatched(top, ch)) return false;
            }
        }
        return stack.isEmpty();

    }

    private boolean bracketMatched(Character left, Character right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isRightBracket(Character ch) {
        return rightBrackets.contains(ch);
    }


    private boolean isLeftBracket(Character ch) {
        return leftBrackets.contains(ch);
    }

}
