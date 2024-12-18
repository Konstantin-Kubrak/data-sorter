package kubrak.konstantin;

import java.util.List;

//класс предназначен для вывода статистики
public class DataStatistics {


    public static void statisticShort(List<?> list, String type){

        if(!list.isEmpty()){
            System.out.println("Количество элементов типа " + type + ": " + list.size());
        }

    }

    public static void statisticNumberFull(List<? extends Number> list, String type){

        if(!list.isEmpty()){

            Double min = list.stream().map(Number::doubleValue).min(Double::compareTo).get();
            Double max = list.stream().map(Number::doubleValue).max(Double::compareTo).get();
            Double sum = list.stream().map(Number::doubleValue).reduce(0.0, Double::sum);
            double average = sum / list.size();
            System.out.println("Количество элементов типа " + type + ": " + list.size());
            System.out.println("Минимальное значение типа " + type + ": " + min);
            System.out.println("Максимальное значение типа " + type + ": " + max);
            System.out.println("Сумма значений типа " + type + ": " + sum);
            System.out.println("Среднее значение типа " + type + ": " + average);
            System.out.println("===================================================\n");
        }
    }

    public static void statisticStringFull(List<String> list){

        if(!list.isEmpty()){
            int min = list.stream().map(String::length).min(Integer::compare).get();
            int max = list.stream().map(String::length).max(Integer::compare).get();
            System.out.println("Количество элементов типа \"строка\": " + list.size());
            System.out.println("Длина самой короткой строки: " + min);
            System.out.println("Длина самой длинной строки: " + max);
            System.out.println("===================================================\n");
        }
    }
}
