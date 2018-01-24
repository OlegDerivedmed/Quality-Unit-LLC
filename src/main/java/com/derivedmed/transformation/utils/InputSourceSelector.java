package com.derivedmed.transformation.utils;

import com.derivedmed.transformation.input.InputSource;
import com.derivedmed.transformation.input.InputSourceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Util class which helps to chose what kind of input we want to get.
 */
public class InputSourceSelector {
    private static final Logger logger = Logger.getLogger(InputSourceSelector.class.getName());
    public static InputSource getInputSource() {
        InputSource inputSource=null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Select Input type. Enter 'c' if from console, enter 'f' if from file :");
            String filename;
            while (true) {
                String inputType = reader.readLine();
                if (inputType.equals("f")) {
                    System.out.println("Put your file in resources and enter its name");
                    filename = reader.readLine();
                    inputSource = InputSourceFactory.getInstance().getFileSource(filename);
                    break;
                }
                if (inputType.equals("c")) {
                    inputSource = InputSourceFactory.getInstance().getConsoleSource();
                    break;
                }
                System.out.println("Enter valid symbol (c/f)");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING,"IOException found",e);
        }
        return inputSource;
    }
}
