package prac.chapter02.item08;

import sun.misc.Cleaner;

public class Room implements AutoCloseable {
    // private final Cleaner cleaner = Cleaner.create(room, state);

    private static class State implements Runnable {
        int num_junk_piles;

        State(int num_junk_piles) {
            this.num_junk_piles = num_junk_piles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            num_junk_piles = 0;
        }
    }
    
    private final State state; 
    // private final Cleaner.Cleanable cleanable;

    public Room(int num_junk_piles) {
        state = new State(num_junk_piles);
        // cleanable = cleaner.register(this, state);
    }

    @Override 
    public void close() {
        // cleanable.clean();
        // cleaner.clean();
    }

}