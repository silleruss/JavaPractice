package prac.chapter02.create_destroy;

import java.time.Instant;
import java.util.*;

// 객체의 생성과 파괴
public class Main {

    public static Boolean valueOf(final boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(final String[] args) {
        final int a = 2;
        final int b = 1;
        final Boolean checker = valueOf(a == b);
        System.out.println("boolean valueOf : "+checker);

        final boolean temp = (a > b) ? true : false;
        System.out.println(Boolean.valueOf(temp));

        final Instant instant = Instant.now();
        final Date d = Date.from(instant);
        System.out.println("now : "+d);

        final Long id = 1L;
        // 동일 생성자 check
        final SampleClass sampleClassByIdName = SampleClass.newSampleClassByIdName(id, d.toString());
        final SampleClass sampleClassByIdName2 = SampleClass.newSampleClassByIdName(id, d.toString());
        
        System.out.println(sampleClassByIdName+"\n"+sampleClassByIdName2);

        final SampleAbstractClass spac = SampleAbstractClass.getCheckerValueOf(checker);
        spac.getToStringResult();

        
    }
}