package com.derivedmed.transformation;


import com.derivedmed.transformation.controller.Transformer;

public class Main {
    public static void main(String[] args) {

        Transformer transformer = Transformer.getInstance();
        transformer.start();
    }
}
