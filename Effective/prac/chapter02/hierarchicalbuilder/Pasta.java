package prac.chapter02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pasta {
    public enum Sauce { TOMATO, OIL, CREAM }
    final Set<Sauce> sauces;
    
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Sauce> sauces = EnumSet.noneOf(Sauce.class);
        
        public T addSauce(Sauce sauce) {
            sauces.add(Objects.requireNonNull(sauce));
            return self();
        }

        abstract Pasta build();

        protected abstract T self();
    }

    Pasta(Builder<?> builder) {
        sauces = builder.sauces.clone();
    }
}