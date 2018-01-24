package com.derivedmed.transformation.simbols;

import java.util.HashMap;

/**
 * Priority of our algebraic operators.
 */
public class AlgebraicOperatorsPriority {

    private static AlgebraicOperatorsPriority algebraicOperatorsPriority = new AlgebraicOperatorsPriority();
    public final HashMap<Character, Integer> priority;

    public static AlgebraicOperatorsPriority getInstance() {
        return algebraicOperatorsPriority;
    }

    private AlgebraicOperatorsPriority() {
        priority = new HashMap<>();
        priority.put('^', 3);
        priority.put('*', 2);
        priority.put('-', 1);
        priority.put('+', 0);
        priority.put('(',-1);
        priority.put(')',-2);
    }
}
