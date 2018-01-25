package com.derivedmed.transformation.input;

import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * InputSeource from console.
 */
public class ConsoleSource implements InputSource {
    static final org.apache.logging.log4j.Logger userLogger = LogManager.getLogger("Logger");

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
            userLogger.info("HelloFromConsole");
        }
        return Optional.empty();
    }
}
