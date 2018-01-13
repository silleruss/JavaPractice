
public class ThreadTest {
	
	public static int func() {
	    int cnt = 0;
	    // 2^10
	    for (int i = 0; i <= 1024; ++i) {
	        if ((i & (i - 1)) == 0) {
	            ++cnt;
	        }
	    }
	    return cnt;
	}
	
	 private volatile int count = 0;
	    private void run() throws InterruptedException {
	        Thread t1 = new Thread(() -> {
	                               for (int i = 0; i < 100000; i++) { count++; }
	                               });
	        Thread t2 = new Thread(() -> {
	                               for (int i = 0; i < 100000; i++) { count++; }
	                               });
	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join();

	        System.out.println(count);
	    }
	    
	    public static void main(String[] args) throws Exception {
	        new ThreadTest().run();
	        System.out.println(func());
	    }
}
