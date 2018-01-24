package com.derivedmed.transformation.controller;


import com.derivedmed.transformation.input.ConsoleSource;
import com.derivedmed.transformation.input.InputSource;
import com.derivedmed.transformation.input.InputSourceCreator;
import com.derivedmed.transformation.simbols.Simbols;

import java.util.List;
import java.util.Stack;

public class Transformer {
    private static Transformer transformer = new Transformer();
    private Simbols simbols;
    private InputSourceCreator inputSourceCreator = InputSourceCreator.getInstance();
    private InputSource inputSource;

    public static Transformer getInstance() {
        return transformer;
    }

    private Transformer() {
        simbols = Simbols.getInstance();
        inputSource = new ConsoleSource();
    }

    public void start(){
        /*
        * If U want to get input from console Just ask inputSourceCreator to return ConsoleSource.
        * */
        inputSource = inputSourceCreator.getFileSource("test.txt");
        List<String> inputs = inputSource.getInput();
        for (String input : inputs){
            if (simbols.checkExp(input)){
                System.out.println(transform(input));
            }
        }
    }


    private String transform(String exp) {

        StringBuilder result = new StringBuilder();
        Stack<Character> operatorsStack = new Stack<>();
        char[] expString = exp.toCharArray();
        for (int i = 0; i < expString.length; i++) {
            int priority = simbols.getPriority(expString[i]);
            if (priority == Integer.MAX_VALUE) {
                result.append(expString[i]);
            }
            if (priority != Integer.MAX_VALUE&&priority!=-1&&priority!=-2) {
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
