package prac.chapter02.item01.create_destroy;

abstract class SampleAbstractClass {
    public abstract void getToStringResult();

    public static SampleAbstractClass getCheckerValueOf(Boolean checker) {
        if(Boolean.valueOf(checker)) {
            return new isTrue();
        } else {
            return new isFalse();
        }
    }
}

class isTrue extends SampleAbstractClass {
    @Override
    public void getToStringResult() {
        System.out.println("true");
    }
    
}

class isFalse extends SampleAbstractClass {
    @Override
    public void getToStringResult() {
        System.out.println("false");
    }
}