package prac.chapter02.item02.hierarchicalbuilder;

import static prac.chapter02.item02.hierarchicalbuilder.Pasta.Sauce.*;
import static prac.chapter02.item02.hierarchicalbuilder.TomatoPasta.Size.*;

public class PastaTest {
    
    public static void main(String[] args) {
        TomatoPasta tomato = new TomatoPasta.Builder(SMALL)
                .addSauce(TOMATO).build();
        OilPasta oil = new OilPasta.Builder()
                .addSauce(OIL).meatInside().build();
        
        System.out.println(tomato);
        System.out.println(oil);
    }
}