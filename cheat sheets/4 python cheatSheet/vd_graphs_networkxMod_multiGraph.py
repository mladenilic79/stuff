
# anything not specified here is same as on basic graph

import networkx

# ----- graphs ------

# Create empty graph
G = networkx.MultiGraph()

# ----- edges & edges attributes -----

# input edges with return key, the lowest unused integer by default
key = G.add_edge(1, 2)
key = G.add_edge(1, 2, weight=4.7 )
keys = G.add_edges_from([(1, 2), (1, 3)])
keys = G.add_edges_from([(4,5,{'route':28}), (4,5,{'route':37})])
keys = G.add_edges_from([(3, 4), (4, 5)], color='red')
H = networkx.path_graph(5)
keys = G.add_edges_from(H.edges)

# accessing & editing attributes
G[1][2][0]['weight'] = 4.7
G.edges[1, 2, 0]['weight'] = 4

# returns first unused edge key for specified pair of nodes
a = G.new_edge_key(1, 2)
