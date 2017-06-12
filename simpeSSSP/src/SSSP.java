import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
        adjacencies = new ArrayList<Edge>();
    }

    public void addEdge(Edge e) {
        adjacencies.add(e);
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}


public class SSSP {

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u

            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }

            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    @SuppressWarnings("resource")
	public static void main(String args[]) {
    	String pathOutput = null;
    	int totalWeight = 0;
        Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();
        BufferedReader vert, edge, input = null;
        StringBuffer sb = null;
        
        try {
        	vert = new BufferedReader(new FileReader("vertex.txt"));
        	edge = new BufferedReader(new FileReader("edge.txt"));
        	input = new BufferedReader(new FileReader("input.txt"));
        	
            String line;
            //boolean inVertex = true;

            while((line = vert.readLine()) != null) {
            	String[] indexOfrest = line.split(",");
            	String vertexId = indexOfrest[0];
            	String vertexName = indexOfrest[1];
            	String lineNumber = indexOfrest[2];
            	
            	Vertex v = new Vertex(vertexName);
            	vertexMap.put(vertexId, v);
            }
            
            while((line = edge.readLine()) != null) {
            	String[] indexOfrest = line.split(",");
            	String vFrom = indexOfrest[0];
            	String vTo = indexOfrest[1];
            	int weight = Integer.parseInt(indexOfrest[2]);
            	Vertex v = vertexMap.get(vFrom);
            	if(v != null) {
            		v.addEdge(new Edge(vertexMap.get(vTo), weight));
            	}
            }
            
            while((line = input.readLine()) != null) {
            	String Start = line;
            	String End = line;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //get a list of all the vertices
        Collection<Vertex> vertices = vertexMap.values();
        Vertex source = vertices.iterator().next();
        //System.out.println("Computing paths from " + source);
        computePaths(source);
        for (Vertex v : vertices) {
            //System.out.println("Distance to " + v + ": " + v.minDistance);
            List<Vertex> path = getShortestPathTo(v);
            pathOutput = path+" ";
            
            if(v.minDistance != Double.POSITIVE_INFINITY)
            	totalWeight = (int)v.minDistance;
        }
        
        pathOutput = pathOutput.replace("[","");
        pathOutput = pathOutput.replace(",", "->");
        pathOutput = pathOutput.replace("]", "");
        
        System.out.print(pathOutput);
        System.out.print("\n"+totalWeight);
    }
}
