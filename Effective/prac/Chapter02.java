package prac;

import java.time.Instant;
import java.util.*;

public class Chapter02 {

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        Boolean checker = valueOf(a == b);
        System.out.println("boolean valueOf : "+checker);

        boolean temp = (a > b) ? true : false;
        System.out.println(Boolean.valueOf(temp));

        Instant instant = Instant.now();
        Date d = Date.from(instant);
        System.out.println("now : "+d);

        Long id = 1L;
        SampleClass sampleClassByIdName = SampleClass.newSampleClassByIdName(id, d.toString());
        SampleClass sampleClassByIdName2 = SampleClass.newSampleClassByIdName(id, d.toString());
        
        System.out.println(sampleClassByIdName+"\n"+sampleClassByIdName2);


        SampleAbstractClass spac = SampleAbstractClass.getCheckerValueOf(checker);
        spac.getToStringResult();
    }
}