package prac.chapter02.hierarchicalbuilder;

import static prac.chapter02.hierarchicalbuilder.Pasta.Sauce.*;
import static prac.chapter02.hierarchicalbuilder.TomatoPasta.Size.*;

public class PastaTest {
    
    public static void main(String[] args) {
        TomatoPasta tomato = new TomatoPasta.Builder(SMALL)
                .addSauce(TOMATO).build();
        OilPasta oil = new OilPasta.Builder()
                .addSauce(OIL).noodleInside().build();
        
        System.out.println(tomato);
        System.out.println(oil);
    }
}