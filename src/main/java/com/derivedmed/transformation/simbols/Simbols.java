package com.derivedmed.transformation.simbols;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simbols {

    private static Simbols simbols = new Simbols();
    private final HashMap<Character, Integer> priority;

    public static Simbols getInstance() {
        return simbols;
    }

    private Simbols() {
        priority = new HashMap<>();
        priority.put('^', 3);
        priority.put('*', 2);
        priority.put('-', 1);
        priority.put('+', 0);
        priority.put('(',-1);
        priority.put(')',-2);
    }


    public boolean checkExp(String expression) {
        Pattern p = Pattern.compile("^[a-z0-9(^*+\\d-)]+");
        Matcher m = p.matcher(expression);
        return m.matches();
    }

    public int getPriority(char c) {
        if (priority.get(c)==null){
            return Integer.MAX_VALUE;
        }
        return priority.get(c);
    }
}
