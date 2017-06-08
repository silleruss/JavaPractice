
public class RunKruskal {
	
	public static void main(String[] args) {
		SimpleKruskal g_MST = new SimpleKruskal(7);
		g_MST.addEdge('A', 'B', 6);
		g_MST.addEdge('A', 'C', 2);
		g_MST.addEdge('A', 'D', 16);
		g_MST.addEdge('A', 'G', 14);
		g_MST.addEdge('B', 'D', 5);
		g_MST.addEdge('B', 'E', 4);
		g_MST.addEdge('C', 'B', 7);
		g_MST.addEdge('C', 'E', 3);
		g_MST.addEdge('C', 'F', 8);
		g_MST.addEdge('D', 'G', 3);
		g_MST.addEdge('E', 'D', 4);
		g_MST.addEdge('E', 'G', 10);
		g_MST.addEdge('F', 'G', 1);
		g_MST.mst();
	}
}
