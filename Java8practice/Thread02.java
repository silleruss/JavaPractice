import java.util.concurrent.locks.ReentrantLock;

public class Thread02 implements Runnable {
    static int counter = 1;
    static ReentrantLock counterLock = new ReentrantLock(true); // enable fairness policy
    static final int MAXVALUE = 1000000;

    static long startTime = 0;
    static long endTime = 0;

    static void increCounter() {
        counterLock.lock();

        try {
            // System.out.println(Thread.currentThread().getName()+": "+counter);
            counter++;
        }
        finally {
            if(counter == MAXVALUE)
            {
                endTime = System.currentTimeMillis();
                System.out.println( "execution time : " + ( endTime - startTime ) / 1000.0 );
            }
            counterLock.unlock();
        }
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();

        while(counter < MAXVALUE)
        {
            increCounter();
        }
    }

    public static void main(String[] args) {
        Thread02 t = new Thread02();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        // Thread t3 = new Thread(t);
        // Thread t4 = new Thread(t);
        // Thread t5 = new Thread(t);

        t1.start();
        t2.start();
        // t3.start();
        // t4.start();
        // t5.start();
    }
}