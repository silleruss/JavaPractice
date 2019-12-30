package prac.chapter02.item03.field;

public class SingleTon {
    public static final SingleTon INSTANCE = new SingleTon();

    private SingleTon () { };

    public void tempMethod() {
        System.out.println("Field Out");
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.INSTANCE;
        singleTon.tempMethod();
    }

}