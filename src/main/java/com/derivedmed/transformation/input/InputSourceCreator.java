package com.derivedmed.transformation.input;

public class InputSourceCreator {
    private static InputSourceCreator inputSourceCreator = new InputSourceCreator();
    public static InputSourceCreator getInstance(){
        return inputSourceCreator;
    }
    private InputSourceCreator(){

    }
    public ConsoleSource getConsoleSource(){
        return new ConsoleSource();
    }

    public FileSource getFileSource(String fileName){
        return new FileSource(fileName);
    }
}
