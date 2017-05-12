
import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency;
    public HuffmanTree(int freq) { frequency = freq; }

    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {
    public final char value; 
    
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right;
    
    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

public class Huffman {
    HuffmanTree root;
    String output;
    private int[] frequency;
    private char[] alphabet;
    PriorityQueue<String> report;
    
    public Huffman(int[] frequency, char[] alphabet) {
    	this.frequency = frequency;
    	this.alphabet = alphabet;
    	root = buildTree(this.frequency, this.alphabet);
    	output = "";
    }
    
    public HuffmanTree buildTree(int[] frequency, char[] alphabet) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        for (int i = 0; i < frequency.length; i++)
            if (frequency[i] > 0)
                trees.offer(new HuffmanLeaf(frequency[i], alphabet[i]));

        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }
    
    public void printCodes(HuffmanTree tree, StringBuffer prefix) {
    	
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            report.add(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    
    public String toString() {
    	String str = "SYMBOL\tFREQ\tHUFFMAN CODE\n";
    	report = new PriorityQueue<String>();
    	printCodes(root, new StringBuffer());
    	
    	while(!report.isEmpty())
    		str += report.poll()+"\n";
    	
    	return str;
    }
}