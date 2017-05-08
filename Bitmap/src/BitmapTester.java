// Name: Seung_Ryoung_Lee
// Student Number: 2017-90730;

public class BitmapTester {
	public static void main(String[] args) {
		Bitmap a = new MyBitmap("11001111011010101010");
		Bitmap b = new MyBitmap("11001111000011111111");
		
		System.out.println(a.and(b)); //11001111000010101010
		System.out.println(a.or(b));  //11001111011011111111
		System.out.println(a.xor(b)); //00000000011001010101
		a.lshift(4);
		System.out.println(a); //110011110110101010100000

		a.rshift(8);		   
		System.out.println(a); //000000001100111101101010

		a.cut(5, 12);
		System.out.println(a); //0000011101101010	
		System.out.println(a.rank(7)); //3
		System.out.println(a.select(5));//10

		System.out.println(b.dataSize());//2
		System.out.println(a.dataSize());//1

		Bitmap c = new MyBitmap("1001");
		Bitmap d = new MyBitmap("1011");
		System.out.println(c.dotproduct(d));//2
	}
}