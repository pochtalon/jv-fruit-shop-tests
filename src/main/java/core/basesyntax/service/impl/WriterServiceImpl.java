package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String outputPath, String report) {
        if (Files.notExists(Paths.get(outputPath))) {
            throw new RuntimeException("File doesn't exist");
        }
        try {
            Files.writeString(Paths.get(outputPath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + outputPath, e);
        }
    }
}
