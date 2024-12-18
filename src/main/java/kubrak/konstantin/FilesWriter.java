package kubrak.konstantin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//класс для записи файлов
public class FilesWriter {

    public static void writeFile(String filePath, String filePrefix, String fileName, boolean append, String content) {

        if(content.isBlank()){
            return;
        }
        String file = filePrefix + fileName;
        if (!filePath.isEmpty()) {
            file = filePath + "\\" + file;
        }

        try (FileWriter fw = new FileWriter(file, append)) {
            fw.write(content);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так, возможно введён некорректный префикс для файла.");
            throw new RuntimeException(e);
        }

    }

    public static String prepareContent(List<?> content) {


        StringBuilder sb = new StringBuilder();
        for (Object o : content) {
            sb.append(o.toString()).append("\n");
        }
        return sb.toString();
    }

}
