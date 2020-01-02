package prac.chapter02.item06;

import java.util.regex.Pattern;

public class EmailRegex {

    static boolean isValidEmailRegexSlow(String s) {
        return s.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    }

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    static boolean isValidEmailRegexFast(String s) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(s).matches();
    }
    
    public static void main(String[] args) {
        boolean b = false;
        String email_1 = "test@test.com";

        long start = System.nanoTime();
        b ^= isValidEmailRegexSlow(email_1);
        // b ^= isValidEmailRegexFast(email_1);

        long end = System.nanoTime();
        System.out.println(((end - start) / (1_000. )) + " μs.");

        System.out.println(b);

        // if(!b) {
        //     System.out.println(b);
        // }
    }
}