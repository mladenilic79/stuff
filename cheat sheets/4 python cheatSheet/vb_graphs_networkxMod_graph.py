
# a Graph is a collection of nodes (vertices) along with identified pairs of
# nodes (called edges, links, etc)

# In NetworkX, nodes can be any hashable object e.g., a text string, an image,
# an XML object, another Graph, a customized node object, etc

# NetworkX uses Adjacency list representation for graphs

import networkx

# ----- graphs ------

# Create empty graph
G = networkx.Graph()

# removing all nodes and edges from graph
G.clear()

# Modify graph to prevent further change by adding or removing nodes or edges,
# attributes can still be modified
frozenGraph = networkx.freeze(G)
unfrozenGraph = networkx.Graph(frozenGraph)

# Returns copy of graph G with nodes relabeled using consecutive integers
P = networkx.convert_node_labels_to_integers(G)

# ----- graphs attributes ------

# graph attributes when creating a new graph
G = networkx.Graph(day="Friday")
# or assign them later
G.graph['day'] = "Monday"
G.graph['hour'] = "now"
# recall graph attributes dictionary
a = G.graph


# ----- nodes -----

# add one node at a time
G.add_node(1)
G.add_node("spam")

# add a list of nodes
G.add_nodes_from([2, 3])
G.add_nodes_from("spam")  # adds 4 nodes: 's', 'p', 'a', 'm'

# add any iterable container of nodes
G.add_nodes_from(range(100, 105))
# Returns the Path graph `P_n` of linearly connected nodes
H = networkx.path_graph(5)
G.add_nodes_from(H)

# removing nodes
G.remove_node(3)
G.remove_nodes_from("spam")

# ----- nodes attributes -----

# Add node attributes
G.add_node(1, time='5pm')
G.add_nodes_from([2, 3], time='2pm')

# access attribute from specified node
a = G.nodes[1]
# access attribute from all nodes
a = list(G.nodes(data=True))

# change node attribute to specified node
G.nodes[1]['room'] = 714

# delete specified attribute from specified node
del G.nodes[1]['room']

# ----- edges -----

# add one edge at a time
G.add_edge(1, 2)
G.add_edge(3, 'm')

# unpack edge tuple*
a = (2, 3)
G.add_edge(*a)

# add a list of edges
G.add_edges_from([(1, 2), (2, 3), (4, 2)])
G.add_edges_from([(1, 2, {'weight':89}), (2, 3, {'weight':8}), (4, 2, {'weight':2})])
G.add_weighted_edges_from([('a', 'b', 5.0), ('b', 'c', 3.0), ('a', 'c', 1.0)])

# add any ebunch of edges. An ebunch is any iterable container of edge-tuples
# An edge-tuple can be a 2-tuple of nodes or a 3-tuple with 2 nodes followed by
# an edge attribute dictionary, e.g., (2, 3, {'weight': 3.1415})
G.add_edges_from(H.edges)

# removing edges
G.remove_edge(4, 2)
G.remove_edges_from([(6, 7), (7, 8)])

# ----- edges attributes -----

# Add edge attributes
# attribute weight should be numeric as it is used by algorithms
G.add_edge(1, 2, weight=4.7)
G.add_edges_from([(3, 4), (4, 5)], color='red', weight=3)
G.add_edges_from([(1, 2, {'weight': 7}), (2, 3, {'weight': 8}),
                   (1, 3, {'weight': 2}), (1, 0, {'weight': 55}),
                   (3, 'm', {'weight': 65}), (5, 6, {'weight': 12}),
                   (6, 7, {'weight': 22}), (7, 8, {'weight': 85}),
                   (8, 9, {'weight': 46}), (0, 1, {'weight': 46}),
                   (1, 11, {'weight': 46}), (2, 11, {'weight': 46})])

# return attribute
a = G[1][2]['weight']
a = G.edges[3, 4]['weight']
# return attribute as dictionary value
a = G.get_edge_data(1, 3)
a = G.get_edge_data(1, 3, "default value")

# change edge attributes
G[1][2]['weight'] = 4.7
G.edges[3, 4]['weight'] = 4.2

# ----- getting graph info -----

# getting graph info
a = networkx.info(G)

# checks for type of graph
a = G.is_directed()
a = G.is_multigraph()
a = networkx.is_frozen(G)

# check if graph has any weighted edges
a = networkx.is_weighted(G, weight='weight')
# check if graph has any negatively weighted edges
a = networkx.is_negatively_weighted(G, weight='weight')

# check if graph has any edges
a = networkx.is_empty(G)
# returns weight of all edges combined
a = G.size(weight="weight")

# ----- getting node & edge info -----

# getting specific node info
a = networkx.info(G, 1)

# check if node in graph
a = 1 in G
a = G.has_node(1)
# check for edge in graph
a = G.has_edge(1, 2)

# check for number of nodes
a = len(G)
a = G.order()
a = G.number_of_nodes()
# check for number of edges
a = G.size()
a = G.number_of_edges()

# returns number of edges between two nodes
a = G.number_of_edges(1, 2)
# common_neighbors returns iterator of common neighbours of two nodes
a = networkx.common_neighbors(G, 1, 2)
a = list(a)

# check if specific edge is weighted
a = networkx.is_weighted(G, (1, 2), weight='weight')
# check if specific edge is negatively weighted
a = networkx.is_negatively_weighted(G, (1, 2), weight='weight')

# ----- getting advanced info -----

# Four basic graph properties facilitate reporting:
# G.nodes, G.edges, G.adj and G.degree. These are set-like views of the
# nodes, edges, neighbors (adjacencies), and degrees of nodes in a graph
# They offer a continually updated read-only view into the graph structure

# return list of nodes
a = list(G.nodes)
a = list(G.adj)
a = [n for n in G]

# return list of edges
a = list(G.edges)
a = G.edges.values()
a = G.edges.items()

# return list of edges for nodes
a = list(G.edges(1))
a = list(G.edges([1, 3]))

# return list of adjacent nodes of specified node
a = list(G.neighbors(1))
a = list(G.adj[1])
a = list(G[1])

# return node & degree of the node pairs on all nodes
a = G.degree()
# return degree of the node value
a = G.degree(1)
# return node & degree of the node pairs on specified nodes
a = list(G.degree([0, 1, 2]))

# ----- traversing elements with loops -----

# iterate over nodes
for n in G:
    a = n

# Convenient access to all edges is achieved with the edges property.
for node1, node2, attribute in G.edges.data():
    a = node1
    b = node2
    c = attribute

# or specify attribute in advance
for node1, node2, edgeWeight in G.edges.data('weight'):
    a = node1
    b = node2
    c = edgeWeight

# alternative way of accessing all edges (also very nice)
for nodePairTuple, attributeDict in G.edges.items():
    a = nodePairTuple
    b = attributeDict

# Fast examination of node, adjacency pairs is achieved using
# G.adjacency(), or G.adj.items(). Note that for undirected graphs, adjacency
# iteration sees each edge twice
# nice way for accessing all data
for node, AdjNodesWithEdgesAttributes in G.adj.items():
    # or: for node, dictOfAdjNodesWithEdges in G.adjacency():
    for adjNode, attributesOfEdgeToAdjNode in AdjNodesWithEdgesAttributes.items():
        unpackValue = attributesOfEdgeToAdjNode['weight']
        a = node
        a = AdjNodesWithEdgesAttributes
        a = adjNode
        a = attributesOfEdgeToAdjNode
        a = unpackValue

# ----- making copies & subgraphs -----

# returns a read only (view only) copy of a graph
a = G.copy(as_view=True)
a = G.to_undirected(as_view=True)
a = G.to_directed(as_view=True)

# Returns a full depth copy of the graph
a = G.copy()
a = G.copy(as_view=False)
# Returns a full undirected copy of the graph
a = G.to_undirected()
a = G.to_undirected(as_view=False)
# Returns a full directed copy of the graph
a = G.to_directed()
a = G.to_directed(as_view=False)

# ----- graph generators -----

# ----- adjacency matrix -----

# ----- Converting to and from other data formats -----

# ----- reading & writing graphs -----

# ----- algorithms -----

# undirected weighted - shortest path - dijkstra
# You'd run it once for every node. Weights must be non-negative
a = networkx.dijkstra_path(G, 1, 8)

# ----- drawing -----

# pygraphviz + graphviz
# or
# pydot + graphviz
