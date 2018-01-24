package com.derivedmed.transformation.controller;


import com.derivedmed.transformation.input.InputSource;
import com.derivedmed.transformation.simbols.AlgebraicOperatorsPriority;
import com.derivedmed.transformation.utils.InputSourceSelector;
import com.derivedmed.transformation.utils.Validator;

import java.util.List;
import java.util.Optional;

/**
 * App processes controller.
 *
 */
public class Transformer {
    private static Transformer transformer = new Transformer();
    private AlgebraicOperatorsPriority algebraicOperatorsPriority;
    private InputSource inputSource;

    public static Transformer getInstance() {
        return transformer;
    }

    private Transformer() {
        algebraicOperatorsPriority = AlgebraicOperatorsPriority.getInstance();
    }
//    For app correctly work we need to get inputsource(console or file),
//        get list of rows, check them on validity, transform it and display on console.
    public void start(){
        inputSource = InputSourceSelector.getInputSource();
        Optional<List<String>> inputs = inputSource.getInput();
        for (String input : inputs.get()){
            if (Validator.checkExp(input)){
                System.out.println(TransformRealization.transform(input, algebraicOperatorsPriority));
            }
        }
    }
}
