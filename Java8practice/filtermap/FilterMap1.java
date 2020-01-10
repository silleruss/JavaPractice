package filtermap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterMap1 {

    // simple
    public static String method1(Map<Integer, String> map) {
        String result = "";

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if("Daniel.Kim".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }

        return result;
    }

    // Map -> Stream -> Filter -> String
    public static String method2(Map<Integer, String> map) {
        String result = map.entrySet().stream()
            .filter(x -> "John.Lee".equals(x.getValue()))
            .map(x -> x.getValue())
            .collect(Collectors.joining());

        return result;
    }

    // Map -> Stream -> Filter -> MAP
    public static Map<Integer, String> method3(Map<Integer, String> map) {
        Map<Integer, String> collect = map.entrySet().stream()
            .filter(x -> x.getKey() == 2)
            .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        return collect;
    }

    // else
    public static Map<Integer, String> method4(Map<Integer, String> map) {
        Map<Integer, String> collect = map.entrySet().stream()
            .filter(x -> x.getKey() == 3)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return collect;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Daniel.Kim");
        map.put(2, "John.Lee");
        map.put(3, "Jason.Park");

        System.out.println(method1(map));
        System.out.println(method2(map));
        System.out.println(method3(map));
        System.out.println(method4(map));

    }
}