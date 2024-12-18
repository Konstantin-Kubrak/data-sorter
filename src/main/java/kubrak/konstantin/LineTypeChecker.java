package kubrak.konstantin;

//методы класса проверяют тип строк для их фильтрации
public class LineTypeChecker {

    public static boolean checkIfDoubleType(String line) {

        try{
            double result = Double.parseDouble(line);
            return result != (long) result;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean checkIfLongType(String line) {

        try{
            Long.parseLong(line);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
