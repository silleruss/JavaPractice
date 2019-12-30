package prac.chapter02.item03.enumtype;

public enum SingleTon {
    INSTANCE;

    public void tempMethod() {
        System.out.println("Enum Out");
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.INSTANCE;
        singleTon.tempMethod();
    }
}