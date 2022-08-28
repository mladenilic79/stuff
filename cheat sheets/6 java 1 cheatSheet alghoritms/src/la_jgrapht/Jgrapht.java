package la_jgrapht;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;

public class Jgrapht {
	
	public static void main(String[] args) throws IOException {
		
		// vertices any objects at minimum one label or number (string or int),
		// egdes at minimum defaultedge or defaultweightededge (or subclass them)
		
		// objects
		String o1 = "vertices 1";
		String o2 = "vertices 2";
		String o3 = "vertices 3";
		String o4 = "vertices 4";
		String o5 = "vertices 5";

		// graph 1 undirected
		Graph<String, DefaultEdge> g1 = new SimpleGraph<>(DefaultEdge.class);

		g1.addVertex(o1);
		g1.addVertex(o2);
		g1.addVertex(o3);
		g1.addVertex(o4);
		g1.addVertex(o5);
		
		g1.addEdge(o1, o2);
		g1.addEdge(o1, o3);
        g1.addEdge(o2, o4);
        g1.addEdge(o3, o5);
        g1.addEdge(o2, o5);
        g1.addEdge(o4, o5);

        // graph 2 undirected weighted
		Graph<String, DefaultWeightedEdge> g2 = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		g2.addVertex(o1);
		g2.addVertex(o2);
		g2.addVertex(o3);
		g2.addVertex(o4);
		g2.addVertex(o5);
		
		DefaultWeightedEdge e1 = g2.addEdge(o1, o2);
			g2.setEdgeWeight(e1, 5);
		DefaultWeightedEdge e2 = g2.addEdge(o1, o3);
			g2.setEdgeWeight(e2, 4);
		DefaultWeightedEdge e3 = g2.addEdge(o2, o4);
			g2.setEdgeWeight(e3, 8);
		DefaultWeightedEdge e4 = g2.addEdge(o3, o5);
			g2.setEdgeWeight(e4, 2);
		DefaultWeightedEdge e5 = g2.addEdge(o2, o5);
			g2.setEdgeWeight(e5, 3);
		
		// graph 3 directed
		Graph<String, DefaultEdge> g3 = new SimpleDirectedGraph<>(DefaultEdge.class);
		
		g3.addVertex(o1);
		g3.addVertex(o2);
		g3.addVertex(o3);
		g3.addVertex(o4);
		g3.addVertex(o5);
		
		g3.addEdge(o1, o2);
		g3.addEdge(o1, o3);
        g3.addEdge(o2, o4);
        	g3.addEdge(o4, o2);
        g3.addEdge(o3, o5);
        g3.addEdge(o2, o5);
		
		// graph 4 directed weighted
		Graph<String, DefaultWeightedEdge> g4 = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

		g4.addVertex(o1);
		g4.addVertex(o2);
		g4.addVertex(o3);
		g4.addVertex(o4);
		g4.addVertex(o5);
		
		DefaultWeightedEdge e11 = g4.addEdge(o1, o2);
			g4.setEdgeWeight(e11, 5);
		DefaultWeightedEdge e12 = g4.addEdge(o1, o3);
			g4.setEdgeWeight(e12, 4);
		DefaultWeightedEdge e13a = g4.addEdge(o2, o4);
				g4.setEdgeWeight(e13a, 8);
			DefaultWeightedEdge e13b = g4.addEdge(o4, o2);
				g4.setEdgeWeight(e13b, 8);
		DefaultWeightedEdge e14 = g4.addEdge(o3, o5);
			g4.setEdgeWeight(e14, 2);
		DefaultWeightedEdge e15 = g4.addEdge(o2, o5);
			g4.setEdgeWeight(e15, 3);
		
			
		
/*
if to be added		alghoritm

        			depth first search/paths
					bread first search/paths
to be added			connectivity
to be added			connectivity strong
to be added			cycle shortest
to be added			cycle longest
to be added			eulerian cycle
to be added			eulerian path
to be added			degrees of separation
					shortest path (dijkstra, bellman-ford)
to be added			longest path
to be added			minimum spanning trees
to be added			maximum spanning trees
to be added			maximum flow minimum cut
to be added			linear programming
*/

			
		
		// iteration, getting iterator for use with hasNext() and next() methods (works with any graph)
        System.out.println("getting iterator for use with hasNext() and next() methods (works with any graph)");
        
        DepthFirstIterator<String, DefaultEdge> depthFirstSearchIterator1 = new DepthFirstIterator<>(g1);
        System.out.println(depthFirstSearchIterator1.hasNext());
        System.out.println(depthFirstSearchIterator1.next());

        BreadthFirstIterator<String, DefaultEdge> breadthFirstSearchIterator1 = new BreadthFirstIterator<>(g1);
        System.out.println(breadthFirstSearchIterator1.hasNext());
        System.out.println(breadthFirstSearchIterator1.next());

        DepthFirstIterator<String, DefaultWeightedEdge> depthFirstSearchIterator2 = new DepthFirstIterator<>(g2);
        System.out.println(depthFirstSearchIterator2.hasNext());
        System.out.println(depthFirstSearchIterator2.next());

        BreadthFirstIterator<String, DefaultWeightedEdge> breadthFirstSearchIterator2 = new BreadthFirstIterator<>(g2);
        System.out.println(breadthFirstSearchIterator2.hasNext());
        System.out.println(breadthFirstSearchIterator2.next());

        System.out.println();
        
        

        // Dijkstra Shortest Path (works for any graph)
        System.out.println("Dijkstra Shortest Path");
        
        DijkstraShortestPath<String, DefaultEdge> dijkstraShortestPath3 = new DijkstraShortestPath<>(g3);
        List<String> shortestPathVertices3 = dijkstraShortestPath3.getPath(o1,o5).getVertexList();
        System.out.println(shortestPathVertices3);
        List<DefaultEdge> shortestPathEdges3 = dijkstraShortestPath3.getPath(o1,o5).getEdgeList();
        System.out.println(shortestPathEdges3);
	    
	    DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath4 = new DijkstraShortestPath<>(g4);
	    List<String> shortestPathVertices4 = dijkstraShortestPath4.getPath(o1,o5).getVertexList();
        System.out.println(shortestPathVertices4);
        List<DefaultWeightedEdge> shortestPathEdges4 = dijkstraShortestPath4.getPath(o1,o5).getEdgeList();
        System.out.println(shortestPathEdges4);

        System.out.println();
        
        
        
        // Bellman Ford Shortest Path (works for any graph)
        System.out.println("Bellman Ford Shortest Path");
        
        BellmanFordShortestPath<String, DefaultEdge> bellmanFordShortestPath3 = new BellmanFordShortestPath<>(g3);
        List<String> shortestPathVertices33 = bellmanFordShortestPath3.getPath(o1,o5).getVertexList();
        System.out.println(shortestPathVertices33);
        List<DefaultEdge> shortestPathEdges33 = bellmanFordShortestPath3.getPath(o1,o5).getEdgeList();
        System.out.println(shortestPathEdges33);

	    BellmanFordShortestPath<String, DefaultWeightedEdge> bellmanFordShortestPath4 = new BellmanFordShortestPath<>(g4);
	    List<String> shortestPathVertices44 = bellmanFordShortestPath4.getPath(o1,o5).getVertexList();
        System.out.println(shortestPathVertices44);
        List<DefaultWeightedEdge> shortestPathEdges44 = bellmanFordShortestPath4.getPath(o1,o5).getEdgeList();
        System.out.println(shortestPathEdges44);
        
        System.out.println();
        	
	}
	
}
