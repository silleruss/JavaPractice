
public class HuffmanTest {
    public static void main(String[] args) {

    	char[] alphabet = "12345678".toCharArray();
       int[] frequency = {36, 18, 12, 9, 7, 6, 5, 4};
        
       Huffman huff = new Huffman(frequency, alphabet);
       System.out.println(huff);
        
    }   
}