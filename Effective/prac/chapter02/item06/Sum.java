package prac.chapter02.item06;

import java.util.Comparator;

// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    private static long sum() {
        // Long sum = 0L;
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        long x = 0;

        long start = System.nanoTime();
        x += sum();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}