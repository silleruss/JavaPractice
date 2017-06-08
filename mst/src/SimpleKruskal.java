import java.util.*;

public class SimpleKruskal {
	private PriorityQueue<Edge> queue;
	private int total_vertex;
	private boolean[][] vertices;
	
	public SimpleKruskal(int total_vertex) {
		queue = new PriorityQueue<Edge>();
		this.total_vertex = total_vertex;
	}
	public void addEdge(char v1, char v2, int w) {
		queue.offer(new Edge(v1, v2, w));
	}
	
	public class Edge implements Comparable<Edge>{
		public char v1;
		public char v2;
		public int w;
		public Edge(char vertex1, char vertex2, int weight) { v1=vertex1;v2=vertex2;w=weight;}
		public int compareTo(Edge e) { return w-e.w;}
	}

	public void mst() {
		int edge_count = 0;
		vertices = new boolean[total_vertex][total_vertex];
		LinkedList<Edge> mst_list = new LinkedList<Edge>();
		for(int i = 0; i < total_vertex; i++)
			for(int j = 0; j < total_vertex; j++)
				vertices[i][j] = false;
	
		while(!queue.isEmpty()&& edge_count < total_vertex -1) {
			Edge e = queue.poll();
			if(check(e.v1, e.v2)) { //check if reachable
				edge_count++;
				mst_list.add(e);
				vertices[e.v1-65][e.v2-65] = true;
				vertices[e.v2-65][e.v1-65] = true;
			}
		}
	
		for(int i = 0; i < mst_list.size(); i++) {
			Edge temp = mst_list.get(i);
			System.out.println(temp.v1 + "\t" + temp.v2  + "\t" + temp.w);
		}
	}

	private boolean check(char a, char b) {
		// alphabet ASCII invert integer
		int v1 = a-65;
		int v2 = b-65;
		boolean[] visited_vertex = new boolean[total_vertex];
		
		for(int i = 0; i < total_vertex; i++)
			visited_vertex[i] = false;
		
		LinkedList<Integer> bfs = new LinkedList<Integer>();
		bfs.add(v1);
		
		while(!bfs.isEmpty()) {
			int temp = bfs.pop();
			if(temp == v2)
				return false;

			if(!visited_vertex[temp]) {
				visited_vertex[temp] = true;
				for(int i = 0; i < total_vertex; i++)
					if(temp != i && vertices[temp][i] == true && !visited_vertex[i] && !bfs.contains(i)) {
						bfs.add(i);
				}
			}
		}
		
		return true;
	}
	
}
