package com.derivedmed.transformation.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleSource implements InputSource{

    public ConsoleSource() {
    }

    @Override
    public List<String> getInput() {
        List<String> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true){
                String exp = reader.readLine();
                if (exp.equals("")) break;
                input.add(exp);
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
