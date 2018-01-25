package com.derivedmed.transformation.controller;

import com.derivedmed.transformation.symbols.AlgebraicOperatorsPriority;
import com.derivedmed.transformation.utils.Validator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * infix - RPN algorithm realization.
 */
class TransformRealization {
    private TransformRealization() {

    }

    static String transform(String exp, AlgebraicOperatorsPriority algebraicOperatorsPriority) {

        StringBuilder result = new StringBuilder();
        Deque<Character> operatorsStack = new LinkedList<>();
        char[] expString = exp.toCharArray();
        for (char character : expString) {
            int priority = Validator.getPriority(character, algebraicOperatorsPriority);
            if (priority == Integer.MAX_VALUE) {
                result.append(character);
            }
            if (priority != Integer.MAX_VALUE && priority != -1 && priority != -2) {
                while (operatorsStack.size() != 0 && priority <= Validator.getPriority(operatorsStack.peek(), algebraicOperatorsPriority)) {
                    result.append(operatorsStack.pop());
                }
                operatorsStack.push(character);
            }
            if (priority == -1) {
                operatorsStack.push(character);
            }
            if (priority == -2) {
                while (Validator.getPriority(operatorsStack.peek(), algebraicOperatorsPriority) != -1) {
                    result.append(operatorsStack.pop());
                }
                operatorsStack.pop();
            }
        }
        if (operatorsStack.size() != 0) {
            while (operatorsStack.size() != 0) {
                result.append(operatorsStack.pop());
            }
        }
        return result.toString();
    }
}
