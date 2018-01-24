package com.derivedmed.transformation.input;

/**
 * Factory of InputSources.
 */
public class InputSourceFactory {

    private static InputSourceFactory inputSourceFactory = new InputSourceFactory();
    public static InputSourceFactory getInstance(){
        return inputSourceFactory;
    }
    private InputSourceFactory(){

    }
    public ConsoleSource getConsoleSource(){
        return new ConsoleSource();
    }

    public FileSource getFileSource(String fileName){
        return new FileSource(fileName);
    }
}
