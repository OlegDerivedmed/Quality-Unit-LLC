package com.derivedmed.transformation.input;

import java.util.List;
import java.util.Optional;

public interface InputSource {
    Optional<List<String>> getInput();
}
