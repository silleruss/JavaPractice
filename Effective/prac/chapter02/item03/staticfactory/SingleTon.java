package prac.chapter02.item03.staticfactory;

public class SingleTon {
    public static final SingleTon INSTANCE = new SingleTon();
    private SingleTon () { };
    public static SingleTon getInstance() { return INSTANCE; }

    public void tempMethod() {
        System.out.println("Static Factory Out");
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        singleTon.tempMethod();
    }

}