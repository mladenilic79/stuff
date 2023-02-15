
# anything not specified here is same as on basic graph

import networkx

# ----- graphs ------

# Create empty graph
G = networkx.DiGraph()

# input some data
G.add_edges_from([(1, 2), (2, 3), (4, 2)])
G.add_edges_from([(1, 2, {'weight':89}), (2, 3, {'weight':8}), (4, 2, {'weight':2})])
G.add_weighted_edges_from([('a', 'b', 5.0), ('b', 'c', 3.0), ('a', 'c', 1.0)])
G.add_edges_from([(3, 4), (4, 5)], color='red', weight=3)
G.add_edges_from([(1, 2, {'weight': 7}), (2, 3, {'weight': 8}),
                   (1, 3, {'weight': 2}), (1, 0, {'weight': 55}),
                   (3, 'm', {'weight': 65}), (5, 6, {'weight': 12}),
                   (6, 7, {'weight': 22}), (7, 8, {'weight': 85}),
                   (8, 9, {'weight': 46}), (0, 1, {'weight': 46})])

# ----- getting basic info -----

# how many edges are pointing to or from specified node
a = G.in_degree(1)
a = G.out_degree(1)

# ----- traversing elements with loops -----

# Returns an iterator over predecessor/successor nodes of n
for node in G.successors(1):
    a = node
for node in G.predecessors(1):
    a = node

# read-only structure with nodes & attributes of predecessors & successors
for node, datadict in G.succ[1].items():
    a = node
    b = datadict
for node, datadict in G.pred[1].items():
    a = node
    b = datadict

# ----- making copies & subgraphs -----

# reverse digraph create view only
a = G.reverse(False)
# reverse digraph create full copy
a = G.reverse()
a = G.reverse(True)
