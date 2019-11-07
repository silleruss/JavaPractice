
public class Thread01 implements Runnable {
    private static String name;
    private Thread t;

    Thread01(String str) {
        name = str;
        t = new Thread(this, name);
        System.out.println("New Thread: "+t);
        t.start();
    }

    public void run() {
        try {
            for(int i=5; i>0; i--)
            {
                System.out.println(name+": "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(name+ "interrupted");
        }
        System.out.println(name+" exiting. ");
    }

    public static void main(String[] args) {
        new Thread01("One");
        new Thread01("Two");
        new Thread01("Three");

        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.println(name+ "interrupted");
        }
        System.out.println(name+" exiting. ");
    }
}