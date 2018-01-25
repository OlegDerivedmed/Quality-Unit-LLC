package com.derivedmed.transformation.utils;

import com.derivedmed.transformation.symbols.AlgebraicOperatorsPriority;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    AlgebraicOperatorsPriority algebraicOperatorsPriority = AlgebraicOperatorsPriority.getInstance();
    @Test
    public void checkExp() throws Exception {
        String expression = "aa+bb*cc";
        boolean expectation = true;
        boolean result = Validator.checkExp(expression);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void checkExpOnFalse() throws Exception {
        String expression = "aa+bb*cc$";
        boolean expectation = false;
        boolean result = Validator.checkExp(expression);
        Assert.assertEquals(expectation,result);
    }

    @Test
    public void getPriority() throws Exception {
        char test ='c';
        int expectation = Integer.MAX_VALUE;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }

    @Test
    public void getPriorityPlus() throws Exception {
        char test ='+';
        int expectation = 0;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void getPriorityMinus() throws Exception {
        char test ='-';
        int expectation = 1;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void getPriorityMultipl() throws Exception {
        char test ='*';
        int expectation = 2;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void getPriorityDiv() throws Exception {
        char test ='^';
        int expectation = 3;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void getPriorityLeftBr() throws Exception {
        char test ='(';
        int expectation = -1;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }
    @Test
    public void getPriorityRightBr() throws Exception {
        char test =')';
        int expectation = -2;
        int result = Validator.getPriority(test,algebraicOperatorsPriority);
        Assert.assertEquals(expectation,result);
    }


}