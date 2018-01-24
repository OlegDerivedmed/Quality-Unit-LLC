package com.derivedmed.transformation.controller;

import com.derivedmed.transformation.simbols.Simbols;

import java.util.Stack;

public class Realization {
    private Realization() {

    }

    public static String transform(String exp, Simbols simbols) {

        StringBuilder result = new StringBuilder();
        Stack<Character> operatorsStack = new Stack<>();
        char[] expString = exp.toCharArray();
        for (int i = 0; i < expString.length; i++) {
            int priority = simbols.getPriority(expString[i]);
            if (priority == Integer.MAX_VALUE) {
                result.append(expString[i]);
            }
            if (priority != Integer.MAX_VALUE && priority != -1 && priority != -2) {
                while (!operatorsStack.empty() && priority <= simbols.getPriority(operatorsStack.peek()) && priority != -1) {
                    result.append(operatorsStack.pop());
                }
                operatorsStack.push(expString[i]);
            }
            if (priority == -1) {
                operatorsStack.push(expString[i]);
            }
            if (priority == -2) {
                while (simbols.getPriority(operatorsStack.peek()) != -1) {
                    result.append(operatorsStack.pop());
                }
                operatorsStack.pop();
            }
        }
        if (!operatorsStack.empty()) {
            while (!operatorsStack.empty()) {
                result.append(operatorsStack.pop());
            }
        }
        return result.toString();
    }
}
