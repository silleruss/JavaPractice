
import java.util.*;

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    default int fact(int a) {
        int result;

        if(a == 0 || a == 1)
        {
            return 1;
        }
        result = fact(a-1) * a;

        return result;
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}



public class Lambda {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123


        // List<String> names = Arrays.asList("BTC", "ETH", "XRP", "EOS");
        // List<Integer> numbers = Arrays.asList(5, 2, 9, 4);

        // Collections.sort(names, new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         return b.compareTo(a);
        //     }
        // });

        // Collections.sort(names, (String a, String b) -> {
        //     return b.compareTo(a);
        // });

        // Collections.sort(names, (String a, String b) -> b.compareTo(a));

        // Collections.sort(names, (a, b) -> b.compareTo(a));

        // Collections.sort(numbers, (a, b) -> a.compareTo(b));

        // for(int i=0; i<numbers.size(); i++) 
        // {
        //     System.out.print(numbers.get(i)+" ");
        // }

        // System.out.println();

        // Extension Methods
        // Formula formula = new Formula() {
        //     @Override
        //     public double calculate(int a) {
        //         return sqrt(a * 100);
        //     }
        // };

        // System.out.println(formula.calculate(100));
        // System.out.println(formula.sqrt(25));
        // System.out.println(formula.fact(5));
        
    }
}