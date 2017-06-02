import java.io.*;
import java.util.*;

class TopoSort {
	private int V;   // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List
	
	TopoSort(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}
 
	// Function to add an edge into the graph
	void addEdge(int v,int w) {
		 adj[v].add(w); 
	}
 
	void topologiChecker(int v, boolean visited[], Stack stack) {
		visited[v] = true;
		Integer nextIndex;
		
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			nextIndex = it.next();
			if(!visited[nextIndex])
				topologiChecker(nextIndex, visited, stack);
		}
		
		stack.push(new Integer(v));
	}
	
	void topologicalSort() {
		Stack stack = new Stack();
 
		/**** sorting *****/
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++)
			visited[i] = false;
		
		for(int i=0; i<V; i++)
			if(visited[i] == false)
				topologiChecker(i, visited, stack);
		 /**************************/
		// Print contents of stack
		while (stack.empty()==false)
			System.out.print(stack.pop() + " ");
	}
	
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		TopoSort t = new TopoSort(7);
		t.addEdge(0, 3);
		t.addEdge(0, 2);		
		t.addEdge(1, 3);
		t.addEdge(1, 4);
		t.addEdge(3, 6);
		t.addEdge(3, 5);
		t.addEdge(4, 6);
		t.addEdge(2, 5);
 
		System.out.println("Following is a Topological " +
						   "sort of the given graph");
		t.topologicalSort();
		System.out.println();
	}
}