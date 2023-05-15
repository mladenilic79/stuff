
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ COPYING OBJECTS SHALLOW DEEP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# A shallow copy constructs a new compound object and then (to the extent possible) inserts references into it to the objects found in the original.
# A deep copy constructs a new compound object and then, recursively, inserts copies into it of the objects found in the original.

import copy

list_a = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

shallow_basic = list_a.copy()

shallow = copy.copy(list_a)
deep = copy.deepcopy(list_a)
