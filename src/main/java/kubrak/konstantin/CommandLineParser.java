package kubrak.konstantin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class CommandLineParser {

    private static List<String> filesToParse = new LinkedList<>();
    //опционально через флаг -o
    private static String pathToFilesSave = "";
    //опционально через флаг -p
    private static String prefixForFiles = "";
    //опционально через флаг -a
    private static boolean appendDataToFile = false;
    //флаги -s и -f
    private static boolean statisticRequired = false;
    private static boolean fullStatisticRequired = false;


    public static void parseArgs(String[] args) {

        checkIfArgsIsEmpty(args);
        getFilesToParse(args);
        getPathForFilesSave(args);
        getPrefixForFiles(args);
        overrideFile(args);
        defineStatisticsRequiredAndType(args);

    }


    private static void getFilesToParse(String[] args) {

        for (String fileName : args) {
            if (fileName.endsWith(".txt")) {
                try {
                    if (Files.exists(Path.of(fileName))) {
                        filesToParse.add(fileName);
                    } else {
                        System.out.println("Файл \"" + fileName + "\" не найден.\n");
                    }
                }
                catch (Exception e) {
                    System.out.println("Что-то пошло не так. Проверьте название файла.\n");
                }
            }
        }
        if (filesToParse.isEmpty()) {
            System.out.println("Не указаны файлы для обработки либо же указан неверный формат.");
            System.exit(0);
        }
    }

    private static void checkIfArgsIsEmpty(String[] args) {

        if (args.length == 0) {

            System.out.println("Не указаны аргументы при запуске утилиты, укажите хотя бы один файл.");
            System.exit(0);
        }
    }

    private static void overrideFile(String[] args) {

        appendDataToFile = Arrays.stream(args).anyMatch(Predicate.isEqual("-a"));

    }

    private static void getPrefixForFiles(String[] args) {

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-p")) {
                if (i + 1 < args.length) {
                    String prefix = args[i+1];
                    if(prefix.contains("\\") ||
                            prefix.contains("/") ||
                            prefix.contains("\"")||
                            prefix.contains(":") ||
                            prefix.contains("*") ||
                            prefix.contains("?") ||
                            prefix.contains("<") ||
                            prefix.contains(">") ||
                            prefix.contains("|")) {
                        System.out.println("В префиксе введён некорректный символ, префикс применён не будет.");
                        return;
                    }
                    else {
                        prefixForFiles = prefix;
                        return;
                    }
                }
            }
        }
    }

    private static void getPathForFilesSave(String[] args) {

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-o")) {
                if (i + 1 < args.length) {
                    String path = args[i + 1];

                    try {
                        if (Files.exists(Path.of(path))) {
                            pathToFilesSave = path;
                        }
                        else{
                            System.out.println("Директория для сохранения не существует \"" + path + "\", либо недостаточно прав, будет использована директория по умолчанию.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка при открытии директории \"" + path + "\", будет использована директория по умолчанию.");
                    }

                }
                return;
            }
        }
    }

    private static void defineStatisticsRequiredAndType(String[] args){

        for(String data : args){
            if(data.equals("-s")){
                statisticRequired = true;
            }
            else if(data.equals("-f")){
                statisticRequired = true;
                fullStatisticRequired = true;
            }
        }
        if(!statisticRequired){
            System.out.println("No statistics flags provided. At least one statistic flag: -s or -f.\nNo statistic will be printed.");
        }
    }



    public static List<String> getFilesToParse() {
        return filesToParse;
    }

    public static String getPathToFilesSave() {
        return pathToFilesSave;
    }

    public static String getPrefixForFiles() {
        return prefixForFiles;
    }

    public static boolean isAppendDataToFile() {
        return appendDataToFile;
    }

    public static boolean isStatisticRequired() {
        return statisticRequired;
    }

    public static boolean isFullStatisticRequired() {
        return fullStatisticRequired;
    }
}
