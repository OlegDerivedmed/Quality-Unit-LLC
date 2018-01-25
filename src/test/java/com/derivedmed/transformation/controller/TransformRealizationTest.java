package com.derivedmed.transformation.controller;

import com.derivedmed.transformation.symbols.AlgebraicOperatorsPriority;
import com.derivedmed.transformation.utils.Validator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformRealizationTest {
    AlgebraicOperatorsPriority algebraicOperatorsPriority = AlgebraicOperatorsPriority.getInstance();
    @Test
    public void transform() throws Exception {
        String test = "a+b*c";
        String expectation = "abc*+";
        String result = TransformRealization.transform(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }

}