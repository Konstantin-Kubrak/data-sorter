package kubrak.konstantin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//класс для парсинга файлов
public class FilesParser {

    public static void parseFile(String fileName) {

        Path path = Path.of(fileName);
        if (Files.notExists(path)) {
            System.out.println(fileName + " does not exist. Please check and try again.");
        } else {
            try {
                Files.lines(path)
                        .filter(e -> !e.isBlank())
                        .forEach(e -> {
                            if (LineTypeChecker.checkIfDoubleType(e)) {
                                DataStorage.addDouble(Double.parseDouble(e));
                            } else if (LineTypeChecker.checkIfLongType(e)) {
                                DataStorage.addLong(Long.parseLong(e));
                            } else {
                                DataStorage.addString(e);
                            }
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
