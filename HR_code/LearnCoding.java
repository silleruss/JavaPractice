import java.util.*;

class LinkedList {
	LinkedList head;
}

class Node {
	Node head;
	int data;
	Node next;
	
	public Node(int d) {
		data = d; 
		next = null; 
	}
	
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
}

class Tree {
    int data;
    Tree left, right;
 
    public Tree(int item) {
        data = item;
        left = right = null;
    }
}
 
class HashTables {
	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public HashTables(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        
        fillMap(magazineMap, magazine);
        fillMap(noteMap, note);
    }
    
    public void fillMap(Map<String, Integer> map, String value) {
        if (value == null) return;
        
        String[] words = value.split("\\s+");
        
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                Integer current = map.get(word);
                if (current == null) current = 0;
                map.put(word, current + 1);
            }
        }
    }
}

class BinaryString {
	BinaryString(String string){
        for( byte b : string.getBytes() ){
            System.out.print(Integer.toBinaryString(b) + " ");
        }
        System.out.println();
    }
    
    BinaryString(Integer integer){
        System.out.println(Integer.toBinaryString(integer));
    }
}

public class LearnCoding {
	// ��͸� ����ؼ� ��Ʈ ��忡�� ����, ������ ����� ������ ����
	boolean isBST(Tree node, int min, int max) {
        if(node == null)
            return true;
        
        if(node.data < min || node.data > max)
            return false;
        
        return (isBST(node.left, min, node.data-1) && isBST(node.right, node.data+1, max));
    }
	// �� ����
    boolean checkBST(Tree root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // linkedlist�� ��ȯ�ϴ��� �ľ�
    boolean hasCycle(Node head) {
        HashSet<Node> hs = new HashSet<Node>();
        while(head != null) {
        	// �� ��尡 �ִ� ��� HashMap������ cycle���� ��Ÿ����.
        	// �� ��°�� �븣�� ������ ������
            if(hs.contains(head))
                return true;
            // ù��° ����� ��� �ؽ÷� ����
            hs.add(head);
            head = head.next;
        }
        
        return false;
    }
    
    // ȥ�ڼ��� �����ϴ� value�� ��ȯ
    public static int lonelyInteger(int[] a) {
        int lonely = 0;
        for(int i=0; i<a.length; i++)
            lonely ^= a[i];	// XOR ������ -> �� ��Ʈ �κ��� ���� ������ 0 �ٸ��� 1�� ��ȯ
            
        return lonely;
    }
    
    // "[{()}] ���� ��ȣ ���� �ݰ� ��� ��ġ�ϸ� true �ƴϸ� false return"
    public static boolean isBalanced(String expression) {
        Stack<Character> stack  = new Stack<Character>();
        
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        
        return stack.isEmpty();
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        new BinaryString("HackerRank");
        new BinaryString("8675309");
        
        int[] arr = {10, 20, 30, 40, 50};
        int a = 10; int b = 2;
        for(int i : arr)
        	System.out.println(i);
        
        System.out.println(a^b);
        sc.close();
	}
}
