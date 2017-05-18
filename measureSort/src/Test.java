import java.io.*;

public class Test {

	public static void main(String[] args) {
		try {
			int[] number = readFile("number.txt");
			//**********Your sort here************
			sort(number);
			//************************************
			for(int i = 0; i < number.length; i++)
				System.out.print(number[i] + " ");
			System.out.println();
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
	
}
