package prac.chapter02.item02.hierarchicalbuilder;

import java.util.Objects;

public class TomatoPasta extends Pasta {
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pasta.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public TomatoPasta build() {
            return new TomatoPasta(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private TomatoPasta(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "TomatoPasta with "+sauces;
    }
}