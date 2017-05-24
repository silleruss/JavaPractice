import java.io.*;
import java.lang.*;
import java.util.*;

public class Test {
	public static int[] sortNumber;
	public static int[] nonHeapNumber;
	public static int[] initHeapNumber;
	public static int[] bstNumber;
	public static int[] splayNumber;
	public static int[] mergeNumber;
	public static long x1;	// selection sorting measure time
	public static long x2;	// non heap sorting measure time
	public static long x3;	// init heap sorting measure time
	public static long x4;	//	bst sorting measure time
	public static long x5;	// splay tree sorting measure time
	public static long x6; // merge sorting measure time
	public static int arrSize;
	
	public static void main(String[] args) {
		try {
			/*	read file first line number is arraySize
			 *	number100.txt -> in 100 numbers in file, first line number is 100
			 *	number500.txt -> in 500 numbers in file, first line nuber is 500
			 */
			String fileName = "number10.txt";
			int[] number = readFile(fileName);
			sortNumber = initArray(sortNumber, number);
			nonHeapNumber = initArray(nonHeapNumber, number);
			bstNumber = initArray(bstNumber, number);
			splayNumber = initArray(splayNumber, number);
			mergeNumber = initArray(mergeNumber, number);
			//insertNumber = new int[number.length];
			//System.arraycopy(number, 0, insertNumber, 0, number.length);
			//**********Your sort here************
			//sort(number);
			/*
			long start1 = System.nanoTime();
			insertionSort(sortNumber);
			long end1 = System.nanoTime();
			x1 = TimeUnit.MILLISECONDS.convert(end1 - start1, TimeUnit.NANOSECONDS);
			System.out.println("Insertion sort Time spend in ms: " + x1);
			
			long start2 = System.nanoTime();
			nonHeapSort(nonHeapNumber);
			long end2 = System.nanoTime();
			x2 = TimeUnit.MILLISECONDS.convert(end2 - start2, TimeUnit.NANOSECONDS);
			System.out.println("nonHeap sort Time spend in ms: " + x2);
			*/
			//************************************
			
			bstSort(bstNumber);
			//splaytreeSort(splayNumber);
			nonHeapSort(nonHeapNumber);
			mergeSort(mergeNumber);
			System.out.print("Sorted output: ");
			for(int i = 0; i < nonHeapNumber.length; i++) {
				System.out.print(nonHeapNumber[i] + " ");
			}
			System.out.println();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static int[] initArray(int[] list, int[] target) {
		list = new int[target.length];
		System.arraycopy(target, 0, list, 0, target.length);
		return list;
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
	
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	public static void heapify(int[] list) {
		arrSize = list.length - 1;	
		for(int i = arrSize / 2; i >= 0; i--) 
			maxHeap(list, i);
	}
	// Max Heap
	private static int[] maxHeap(int[] list, int i) {
		int left = 2*i;
		int right = 2*i + 1;
		int max = i;
		if(left <= arrSize && list[left] > list[i])
			max = left;
		if(right <= arrSize && list[right] > list[max])
			max = right;
		
		if(max != i) {
			swap(list, i, max);
			maxHeap(list, max);
		}
		
		return list;
	}
	
	private static int[] nonHeapSort(int[] list) {
		heapify(list);
		for(int i = arrSize; i > 0; i--) {
			swap(list, 0, i);
			arrSize = arrSize - 1;
			maxHeap(list, 0);
		}
		
		return list;
	}
	
	private static int[] initHeapSort(int[] list) {
		
		return list;
	}
	
	private static int[] bstSort(int[] list) {
		//	Construct the BST
		BST bst = new BST(list[0]);
		for(int i=1; i<list.length; i++)
			bst.insert(bst.root, list[i]);
		
		//bst.inOrder(bst.root, list, 0);
		//System.out.print("\n"); 
		
		// Store inorder traversal of BST
		int i =0;
		bst.storeSorted(bst.root, list);
		
		bst.inOrder(bst.root);
		System.out.println();
		
		return list;
	}

	private static int[] splaytreeSort(int[] list) {
		SplayTree spt = new SplayTree();
		for(int i=0; i<list.length; i++)
			spt.insert(list[i]);
		
		spt.inorder();
		System.out.println();
		return list;
	}
	private static int[] temp;
	
	private static void mergesort(int low, int high, int[] list) {
		if(low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle, list);
			mergesort(middle + 1, high, list);
			merge(low, middle, high, list);
		}
	}
	
	private static void merge(int low, int middle, int high, int[] list) {
		for(int i = low; i <= high; i++) 
			temp[i] = list[i];
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {
			if(temp[i] <= temp[j]) {
				list[k] = temp[i];
				i++;
			} else {
				list[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			list[k] = temp[i];
			k++;
			i++;
		}
	}
	
	private static int[] mergeSort(int[] list) {
		temp = new int[list.length];
		mergesort(0, list.length - 1, list);
		
		return list;
	}
}

class Node {
	public int element;
	public Node left, right;
	
	public Node(int element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public Node(int element, Node left, Node right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}

class BST {
	public Node root;
	public int i;
	
	public BST(int element) {
		root = new Node(element);
		i = 0;
	}
	
	public void storeSorted(Node node, int[] list) {
		if(node != null) {
			storeSorted(node.left, list);
			list[i] = node.element;
			storeSorted(node.right, list);
		}
	}
		
	public Node insert(Node node, int element) {
		if(node == null) {
			return node = new Node(element);
		}
		if(element < (Integer)node.element) {
			node.left = insert(node.left, element);
		} else {
			node.right = insert(node.right, element);
		}
		
		return node;
	}
	
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.element + " ");
			inOrder(node.right);
		}
	}
}

class SplayNode {    
    SplayNode left, right, parent;
    int element;

    public SplayNode() {
        this(0, null, null, null);
    }          
    public SplayNode(int element) {
        this(element, null, null, null);
    }
    public SplayNode(int element, SplayNode left, SplayNode right, SplayNode parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = element;         
    }    
}

class SplayTree {
    private SplayNode root;
    private int count = 0;

    public SplayTree() {
        root = null;
    }

    public void insert(int element) {
        SplayNode z = root;
        SplayNode p = null;
        while (z != null) {
            p = z;
            if (element < p.element)
                z = z.right;
            else
                z = z.left;
        }
        z = new SplayNode();
        z.element = element;
        z.parent = p;
        if (p == null)
            root = z;
        else if (element < p.element)
            p.right = z;
        else
            p.left = z;
        Splay(z);
        count++;
    }
    public void makeLeftChildParent(SplayNode c, SplayNode p) {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else 
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    public void makeRightChildParent(SplayNode c, SplayNode p) {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }

    private void Splay(SplayNode x) {
        while (x.parent != null) {
            SplayNode Parent = x.parent;
            SplayNode GrandParent = Parent.parent;
            if (GrandParent == null) {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);                 
            } else {
                if (x == Parent.left) {
                    if (Parent == GrandParent.left) {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    } else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                } else {
                    if (Parent == GrandParent.left) {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } else {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }

    public void inorder() {
    	inorder(root);
    }
    private void inorder(SplayNode node){
        if (node != null) {
            inorder(node.left);
            System.out.print(node.element +" ");
            inorder(node.right);
        }
    }
}