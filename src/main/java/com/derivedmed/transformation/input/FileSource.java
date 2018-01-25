package com.derivedmed.transformation.input;

import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Input source from file.
 */
public class FileSource implements InputSource {
    static final org.apache.logging.log4j.Logger userLogger = LogManager.getLogger("Logger");

    private final String PATH;

    FileSource(String path) {
        PATH = path;
    }

    @Override
    public Optional<List<String>> getInput() {
        List<String> inputs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputs.add(line);
            }
        } catch (IOException e) {
            userLogger.info("No input Data. Restart app and input valid path");
        }
        return Optional.of(inputs);
    }

}
