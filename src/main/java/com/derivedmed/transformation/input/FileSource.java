package com.derivedmed.transformation.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSource implements InputSource {

    private StringBuilder PATH = new StringBuilder("src\\main\\resources\\");

    public FileSource(String fileName) {
        this.PATH.append(fileName);
    }

    @Override
    public List<String> getInput() {
        List<String> inputs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputs.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputs;
    }

}
