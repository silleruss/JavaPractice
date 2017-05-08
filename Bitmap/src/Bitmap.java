// Name: Seung_Ryoung_Lee
// Student Number: 2017-90730;

public interface Bitmap {
	public Bitmap or(Bitmap val);
	public Bitmap and(Bitmap val);
	public Bitmap xor(Bitmap val);
	public void lshift(int k);
	public void rshift(int k);
	public void cut(int i, int j);
	public int rank(int k);
	public int select(int k);
	public int dotproduct(Bitmap val);
	public String toString();

	public int dataSize();
	public int bitlength();
	public char[] getData();
}
