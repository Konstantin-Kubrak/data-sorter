package kubrak.konstantin;

import java.util.LinkedList;
import java.util.List;

public class DataStorage {

    private static final List<Long> someLongs = new LinkedList<>();
    private static final List<Double> doubles = new LinkedList<>();
    private static final List<String> strings = new LinkedList<>();




    public static List<Long> getLongs() {
        return someLongs;
    }

    public static void addLong(Long longs) {
        someLongs.add(longs);
    }

    public static List<Double> getDoubles() {
        return doubles;
    }

    public static void addDouble(Double dbl) {
        doubles.add(dbl);
    }

    public static List<String> getStrings() {
        return strings;
    }

    public static void addString(String string) {
        strings.add(string);
    }
}
