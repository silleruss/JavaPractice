package prac.chapter02.item04;

import java.util.Date;

public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }


    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}