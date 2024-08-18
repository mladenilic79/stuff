
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ ORDERED DICT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ordered dict is sort by insertition order, to sort by key or value create new ordered dict combining it with a sort method
# if the value of a certain key is changed, the position of the key remains unchanged in OrderedDict
from collections import OrderedDict

dict1 = {'a': 1, 'b': 2, 'c': 3, 'd': 4}
OrderedDict1 = OrderedDict(dict1)

# move key to the end
OrderedDict1.move_to_end("a", last=True)

# move key to the beginning
OrderedDict1.move_to_end("a", last=False)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DEFAULT DICT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# defaultdict same as dict but have default value for nonexistent key
# default value must be callable, so method that generate a value or a factory
from collections import defaultdict

def default_value():
    return "not present"

d = defaultdict(default_value)
d['a'] = 1
d['b'] = 2

print(d['c'])

# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DEQUE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

# deque.. double ended que.. mutable sequence type
from collections import deque

d = deque([6, 1, 2, 3, 4])

# from right
d.append(1)
# from left
d.appendleft(3)

# from right
d.pop()
# from left
d.popleft()

# add to end right
d.extend([4, 5, 6])
# add to end left
d.extendleft([7, 8, 9])

# rotate all units by number of places
d.rotate(2)
d.rotate(-2)
