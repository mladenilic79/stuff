package lb_graphstream;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphStream {
	
	public static void main(String[] args) throws IOException {
		
		/*
		can be either directed or undirected. you can mix directed and 
		undirected edges by simply consider undirected edges as bidirectional
		*/
		Graph graph = new SingleGraph("Tutorial 1");
		
		// add nodes & edges
		Node n = graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");
		
		// for automatically creating of nodes (instead of above)
		/*
		graph.setStrict(false);
		graph.setAutoCreate( true );
		graph.addEdge( "AB", "A", "B" );
		graph.addEdge( "BC", "B", "C" );
		graph.addEdge( "CA", "C", "A" );
		*/

		// setting & getting attributes (attributes can be any object)
		n.setAttribute("foo", "bar");
	    String value1 = n.getAttribute("foo");
	    n.setAttribute("weight", 1.5);
	    double value2 = n.getAttribute("weight");
	    // set attribute without value
	    n.setAttribute("Truth");
	    // set list attribute & retrieve with
	    n.setAttribute("a lot", 1, 2, 3, 4);
	    Object[] array = n.getAttribute("a lot");
	    
	    // check for attribute
	    if(n.hasAttribute("Truth")) {
	    	System.out.println();
	    }
		// list all attributes
	    for(String key:n.getEachAttributeKey()) {
	        Object value = n.getAttribute(key);
	    }
	    // list all attributes with iterator
	    Iterator<String> i = n.getAttributeKeyIterator();
	    while(i.hasNext()) {
	        Object value = n.getAttribute(i.next());
	    }
	    
	    // remove attribute
	    n.removeAttribute("foo");
	    // remove all attributes
	    n.clearAttributes();
	    
	    // to returns error instead of null for attributes
	    graph.setNullAttributesAreErrors(true);
	    
		// obtaining objects from a graph directly
		Node A = graph.getNode("A");
		Edge AB = graph.getEdge("AB");
		
		// obtaining objects through loops
		for(Edge e:graph.getEachEdge()) {
			System.out.println(e.getId());
		}
		for(Node n1:graph.getEachNode()) {
			System.out.println(n1.getId());
		}
		// or shorthand
		for(Node n2:graph) {
			System.out.println(n2.getId());
		}
		
		// obtaining elements using iterator
		Iterator<? extends Node> nodes = graph.getNodeIterator();
		while(nodes.hasNext()) {
			Node node = nodes.next();
		}
		// same for edges
		Iterator<? extends Edge> edges = graph.getEdgeIterator();
		while(edges.hasNext()) {
			Edge edge = edges.next();
		}

		// various methods on nodes / edges ...
		A.getId();
		AB.getId();
		graph.getNodeCount();
		graph.getNode("A").getIndex();
		String id = graph.getNode(0).getId();
		
		// read-only set of nodes, methods from java.util.Collections can be used
		Collection<Edge> edges2 = graph.getEdgeSet();
		Collection<Node> nodes2 = graph.getNodeSet();

		// converting to adjacency matrix
		int n3 = graph.getNodeCount();
		byte adjacencyMatrix[][] = new byte[n3][n3];
		for (int k = 0; k < n3; k++) {
			for (int j = 0; j < n3; j++) {
				adjacencyMatrix[k][j] = (byte) (graph.getNode(k).hasEdgeBetween(j) ? 1 : 0);
			}
		}

		// adding label to node
		n.addAttribute("ui.label", "A");
		// use CSS for styling (from tutorial)
		// displaying
		graph.display();
		
		/*
		custom algorithms (from tutorial)
		custom dynamic algorithms adds method terminate to end the algorithm (from tutorial)
		custom generators (from tutorial)
		using remote source (from tutorial)
		graph visualization (& CSS for styling) (from tutorial)
		reading files (from tutorial)
		charts (from tutorial)
		*/
		
		// algorithms (from tutorial)
		/*
		
		*/
		
	}

}
