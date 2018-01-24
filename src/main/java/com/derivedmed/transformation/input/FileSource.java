package com.derivedmed.transformation.input;

import com.derivedmed.transformation.utils.InputSourceSelector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Input source from file.
 */
public class FileSource implements InputSource {
    private final Logger logger = Logger.getLogger(InputSourceSelector.class.getName());

    private StringBuilder PATH = new StringBuilder("src\\main\\resources\\");

    FileSource(String fileName) {
        this.PATH.append(fileName);
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
            logger.log(Level.WARNING,"IOException found",e);
        }
        return Optional.of(inputs);
    }

}
