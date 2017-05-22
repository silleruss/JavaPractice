import java.io.*;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class Test {
	public static int[] sortNumber;
	public static int[] insertNumber;
	public static long x1;	// selection sorting measure time
	public static long x2;	// non heap sorting measure time
	public static long x3;	// init heap sorting measure time
	public static long x4;	//	bst sorting measure time
	public static long x5;	// splay tree sorting measure time
	public static long x6; // merge sorting measure time
	
	public static void main(String[] args) {
		try {
			/*	read file first line number is arraySize
			 *	number100.txt -> in 100 numbers in file, first line number is 100
			 *	number500.txt -> in 500 numbers in file, first line nuber is 500
			 */
			int[] number = readFile("number1000.txt");
			insertNumber = new int[number.length];
			System.arraycopy(number, 0, insertNumber, 0, number.length);
			//**********Your sort here************
			//sort(number);
			long start = System.nanoTime();
			insertionSort(insertNumber);
			long end = System.nanoTime();
			x1 = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
			System.out.println("Insertion sort Time spend in ms: " + x1);
			//************************************
			/*
			for(int i = 0; i < insertNumber.length; i++) {
				System.out.print(insertNumber[i] + " ");
			}
			System.out.println();
			*/
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static int[] readFile(String filename) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		int[] list = new int[Integer.parseInt(line)];
		int count = 0;

		while ((line = br.readLine()) != null) {
			list[count++] = Integer.parseInt(line);
		}
		return list;
	}

	private static int[] sort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int j = i;
			while(j > 0 && list[j-1] > list[j]){
				int temp = list[j];
				list[j]=list[j-1];
				list[j-1]=temp;
				j--;
			}
		}
		return list;
	}
	private static int[] insertionSort(int[] list) {
		for(int i=0; i<list.length; i++) {
			int key = list[i];
			int j = i-1;
			while((j>-1) && (list[j] > key)) {
				list[j+1] = list[j];
				j--;
			}
			
			list[j+1] = key;
		}
		return list;
	}
	private static int[] nonHeapSort(int[] list) {
		
		return list;
	}
	private static int[] initHeapSort(int[] list) {
		
		return list;
	}
	private static int[] bstSort(int[] list) {
		
		return list;
	}
	private static int[] splaytreeSort(int[] list) {
		
		return list;
	}
	private static int[] mergeSort(int[] list) {
		
		return list;
	}
}
