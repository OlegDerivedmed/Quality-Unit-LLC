package com.derivedmed.transformation.input;

import com.derivedmed.transformation.utils.InputSourceSelector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InputSeource from console.
 */
public class ConsoleSource implements InputSource {
    private static final Logger logger = Logger.getLogger(InputSourceSelector.class.getName());

    public ConsoleSource() {
    }

    @Override
    public Optional<List<String>> getInput() {
        List<String> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true){
                String exp = reader.readLine();
                if (exp.equals("")) break;
                input.add(exp);
            }
            return Optional.of(input);
        } catch (IOException e) {
            logger.log(Level.WARNING,"IOException found",e);
        }
        return Optional.empty();
    }
}
