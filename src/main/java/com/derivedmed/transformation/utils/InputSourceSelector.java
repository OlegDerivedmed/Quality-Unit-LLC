package com.derivedmed.transformation.utils;

import com.derivedmed.transformation.input.InputSource;
import com.derivedmed.transformation.input.InputSourceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Util class which helps to chose what kind of input we want to get.
 */
public class InputSourceSelector {

    static final Logger userLogger = LogManager.getLogger("Logger");
    public static InputSource getInputSource() {
        InputSource inputSource=null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Select Input type. Enter 'c' if from console, enter 'f' if from file :");
            String filename;
            while (true) {
                String inputType = reader.readLine();
                if ("f".equals(inputType)) {
                    System.out.println("Enter not empty path to file");
                    filename = reader.readLine();
                    inputSource = InputSourceFactory.getInstance().getFileSource(filename);
                    break;
                }
                if ("c".equals(inputType)) {
                    inputSource = InputSourceFactory.getInstance().getConsoleSource();
                    break;
                }
                System.out.println("Enter valid symbol (c/f)");
            }
        } catch (IOException e) {
            userLogger.info("Not correct path");
        }
        return inputSource;
    }
}
