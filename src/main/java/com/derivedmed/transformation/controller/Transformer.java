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
                System.out.println(Realization.transform(input,simbols));
            }
        }
    }
}
