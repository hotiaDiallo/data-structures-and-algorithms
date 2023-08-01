package com.map;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {

    public Character findFirstNonRepeatedChar(String str){
        if(str==null)
            throw new IllegalArgumentException();
        String input = str.trim().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        var chars = input.toCharArray();
        for(var ch: chars){
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        for(var ch: chars){
            if (map.get(ch)==1)
                return ch;
        }
        return Character.MAX_VALUE;
    }
}
