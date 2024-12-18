package kubrak.konstantin;


public class Main {

    public static void main(String[] args) {
        
        CommandLineParser.parseArgs(args);
        
        for (String path : CommandLineParser.getFilesToParse()) {

            FilesParser.parseFile(path);
        }
        if(CommandLineParser.isStatisticRequired()){
            if (CommandLineParser.isFullStatisticRequired()){
                DataStatistics.statisticNumberFull(DataStorage.getLongs(), "\"целое число\"");
                DataStatistics.statisticNumberFull(DataStorage.getDoubles(), "\"дробное число\"");
                DataStatistics.statisticStringFull(DataStorage.getStrings());
            }
            else {
                DataStatistics.statisticShort(DataStorage.getLongs(), "\"целое число\"");
                DataStatistics.statisticShort(DataStorage.getDoubles(), "\"дробное число\"");
                DataStatistics.statisticShort(DataStorage.getStrings(), "\"строка\"");
            }
        }

        String stringsContent = FilesWriter.prepareContent(DataStorage.getStrings());
        String integersContent = FilesWriter.prepareContent(DataStorage.getLongs());
        String floatsContent = FilesWriter.prepareContent(DataStorage.getDoubles());

        FilesWriter.writeFile(
                CommandLineParser.getPathToFilesSave(),
                CommandLineParser.getPrefixForFiles(),
                "integers.txt",
                CommandLineParser.isAppendDataToFile(),
                integersContent);

        FilesWriter.writeFile(
                CommandLineParser.getPathToFilesSave(),
                CommandLineParser.getPrefixForFiles(),
                "floats.txt",
                CommandLineParser.isAppendDataToFile(),
                floatsContent);

        FilesWriter.writeFile(
                CommandLineParser.getPathToFilesSave(),
                CommandLineParser.getPrefixForFiles(),
                "strings.txt",
                CommandLineParser.isAppendDataToFile(),
                stringsContent);
    }
}