package com.derivedmed.transformation.utils;

import com.derivedmed.transformation.simbols.AlgebraicOperatorsPriority;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Util class which have util methods.
 */
public class Validator {
    private static Validator ourInstance = new Validator();

    public static Validator getInstance() {
        return ourInstance;
    }

    private Validator() {
    }
    public static boolean checkExp(String expression) {
        Pattern p = Pattern.compile("^[a-z0-9(^*+\\d-)]+");
        Matcher m = p.matcher(expression);
        return m.matches();
    }

    public static int getPriority(char symbol, AlgebraicOperatorsPriority algebraicOperatorsPriority) {
        if (algebraicOperatorsPriority.priority.get(symbol)==null){
            return Integer.MAX_VALUE;
        }
        return algebraicOperatorsPriority.priority.get(symbol);
    }
}
