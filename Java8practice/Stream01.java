import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream01 {

    // 문자열에서 특정 문자의 갯수 count
    static long countChar(String s, char c) {
        return s.chars()
                .filter(t -> t == c)
                .count();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("dice", "face", "apple", "test", "bird", "fact");
        
        // a로 시작하는 string 대문자로 출력
        list.stream()
            .filter(s -> s.startsWith("a"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);

        String s1 = "thisisteststring";

        System.out.println(countChar(s1, 't'));

        int[] arr1 = {15, 22, 35, 24, 15, 68, 71};

        // 배열의 평균값
        Arrays.stream(arr1)
                .average()
                .ifPresent(System.out::println);
        
        List<String> list2 = Arrays.asList("kim1", "kim2", "kim99");
        
        list2.stream()
            .map(s -> s.substring(3))
            .mapToInt(Integer::parseInt)
            .max()
            .ifPresent(System.out::println);

        // final StringBuilder b = new StringBuilder();
        
        IntStream.range(1, 10)
            .mapToObj(i -> "kim" + i+" ")
            // .forEach((i) -> {b.append(i+" ");});
            .forEach(System.out::print);

        // check stream process
        Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> {
                System.out.println("filter: " + s);
                return s.startsWith("a");
            })
            .map(s -> {
                System.out.println("map: " + s);
                return s.toUpperCase();
            })
            .forEach(s -> System.out.println("forEach: " + s));
    }
}