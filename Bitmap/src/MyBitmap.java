import java.util.Arrays;

// Name: Seung_Ryoung_Lee
// Student Number: 2017-90730;

public class MyBitmap implements Bitmap {

    private char[] bits;

    public MyBitmap(String s) {
        this.bits = s.toCharArray();
    }

    @Override
    public Bitmap or(Bitmap val) {
        int diff = this.bits.length - val.bitlength();
        char[] target = null;

        if (diff < 0) {
            target = new char[this.bits.length + diff];
            Arrays.fill(target, (char) 0);
            System.arraycopy(val.getData(), 0, target, diff, val.bitlength());
        } else if (diff > 0) {
            char[] temp = new char[this.bits.length + diff];
            Arrays.fill(temp, (char) 0);
            System.arraycopy(this.bits, Math.abs(diff), temp, diff, this.bits.length);
            this.bits = temp;
        }

        target = val.getData();
        char[] result = new char[this.bits.length];

        for (int counter = 0; counter < this.bits.length; counter++) {
            if (this.bits[counter] == '1' || target[counter] == '1')
                result[counter] = '1';
            else if (this.bits[counter] == '0' && target[counter] == '0')
                result[counter] = '0';
        }
        
        return new MyBitmap(String.valueOf(result));
    }

    @Override
    public Bitmap and(Bitmap val) {
    	
        int diff = this.bits.length - val.bitlength();
        char[] target = null;

        if (diff < 0) {
            target = new char[this.bits.length + diff];
            Arrays.fill(target, (char) 0);
            System.arraycopy(val.getData(), 0, target, diff, val.bitlength());
        } else if (diff > 0) {
            char[] temp = new char[this.bits.length + diff];
            Arrays.fill(temp, (char) 0);
            System.arraycopy(this.bits, Math.abs(diff), temp, diff, this.bits.length);
            this.bits = temp;
        }

        target = val.getData();
        char[] result = new char[this.bits.length];

        for (int counter = 0; counter < this.bits.length; counter++) {
            if (this.bits[counter] == '1' && this.bits[counter] == target[counter])
                result[counter] = '1';
            else
                result[counter] = '0';
        }
        
        return new MyBitmap(String.valueOf(result));
    }

    @Override
    public Bitmap xor(Bitmap val) {
    	
    	int diff = this.bits.length - val.bitlength();
        char[] target = null;

        if (diff < 0) {
            target = new char[this.bits.length + diff];
            Arrays.fill(target, (char) 0);
            System.arraycopy(val.getData(), 0, target, diff, val.bitlength());
        } else if (diff > 0) {
            char[] temp = new char[this.bits.length + diff];
            Arrays.fill(temp, (char) 0);
            System.arraycopy(this.bits, Math.abs(diff), temp, diff, this.bits.length);
            this.bits = temp;
        }
        
        target = val.getData();
        char[] result = new char[this.bits.length];

        for (int counter = 0; counter < this.bits.length; counter++) {
            if (this.bits[counter] != target[counter])
                result[counter] = '1';
            else
                result[counter] = '0';
        }
        
        return new MyBitmap(String.valueOf(result));
    }

    @Override
    public void lshift(int k) {
    	
        char[] shifted = new char[this.bits.length + k];

        System.arraycopy(this.bits, 0, shifted, 0, this.bits.length);

        for (int counter = this.bits.length; counter < this.bits.length + k; counter++)
            shifted[counter] = '0';

        this.bits = shifted;
    }

    @Override
    public void rshift(int k) {

        System.arraycopy(this.bits, 0, this.bits, k, this.bits.length - k);

        for (int counter = 0; counter < k; counter++)
            this.bits[counter] = '0';
    }

    @Override
    public void cut(int i, int j) {
    	
        if (i > j || i < 0 || j < 0 || i > this.bits.length || j > this.bits.length)
            return;

        char[] temp = new char[this.bits.length - (j - (i - 1))];

        int temp_index = 0;
        for (int counter = 0; counter < this.bits.length; counter++) {
            counter = counter == i ? counter + (j - i + 1) : counter;
            temp[temp_index++] = this.bits[counter];
        }

        this.bits = temp;

    }

    @Override
    public int rank(int k) {
    	
        if (k < 1 || k > this.bits.length)
            return -1;

        int rank = 0;

        for (int counter = 0; counter < k + 1; counter++)
            if (this.bits[counter] == '1')
                rank++;

        return rank;
    }

    @Override
    public int select(int k) {
    	
        if (k < 1 || k > this.bits.length)
            return -1;

        int finder = 0;

        for (int counter = 0; counter < this.bits.length; counter++) {
            finder = this.bits[counter] == '1' ? finder + 1 : finder;
            if (finder == k)
                return counter;
        }

        return -1;
    }

    @Override
    public int dotproduct(Bitmap val) {
    	int result = 0;
    	int temp = 0;
    	
    	for(int counter = 0; counter < val.bitlength(); counter++) {
    		if( (this.bits[counter] == '0') && (val.getData()[counter] == '0') ||
    			(this.bits[counter] == '0') && (val.getData()[counter] == '1') ||
    			(this.bits[counter] == '1') && (val.getData()[counter] == '0'))
    			temp = 0;
    		else if((this.bits[counter] == '1') && (val.getData()[counter] == '1')) {
    			temp = 1;
    			result = result + temp;
    		}
    	}
    	
        return result;
    }

    @Override
    public int dataSize() {
    	
    	// char = 2 byte = 16bits
    	int bitCounter = this.bits.length;
    	int charCounter = 0;
    	boolean checker = true;
    	int charCounterGuide = 17;
    	int counter = 1;

    	while(checker) {
    	    		
    		if(bitCounter > charCounterGuide) {
    			counter ++;
    			charCounterGuide = 17 * counter;
    		}
    		else {
    			charCounter = counter;
    			checker = false;
    		}
    	}
    	
        return charCounter;
    }

    @Override
    public int bitlength() {
        return this.bits.length;
    }

    @Override
    public char[] getData() {
        return this.bits;
    }

    @Override
    public String toString() {
        return String.valueOf(this.bits);
    }

}