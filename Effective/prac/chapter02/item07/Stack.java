package prac.chapter02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack extends IllegalStateException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    // ref not escape
    // public Object pop() {
    //     if(size == 0) {
    //         throw new EmptyStackException();
    //     }

    //     return elements[--size];
    // }

    // Corrected version of pop method
   public Object pop() {
       if (size == 0) {
           throw new EmptyStackException();
       }    
       Object result = elements[--size];
       elements[size] = null; // Eliminate obsolete reference

       return result;
   }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        Stack stack = new Stack();
        for(int x : arr) {
            stack.push(x);
        }

        while(true) {
            System.err.println(stack.pop());
        }
    }

}