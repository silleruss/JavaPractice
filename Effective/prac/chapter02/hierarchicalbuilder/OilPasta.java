package prac.chapter02.hierarchicalbuilder;


public class OilPasta extends Pasta {
    private boolean meatInside;

    public static class Builder extends Pasta.Builder<Builder> {
        private boolean meatInside = false;

        public Builder meatInside() {
            meatInside = true;
            return this;
        }

		@Override
		public OilPasta build() {
			// TODO Auto-generated method stub
			return new OilPasta(this);
		}

		@Override
		protected Builder self() {
			// TODO Auto-generated method stub
			return this;
		}
        
    }

    private OilPasta(Builder builder) {
        super(builder);
        meatInside = builder.meatInside;
    }

    @Override
    public String toString() {
        return String.format("OilPasta with %s and meat %s", sauces, meatInside ? "inside" : "outside" );
    }
    
}