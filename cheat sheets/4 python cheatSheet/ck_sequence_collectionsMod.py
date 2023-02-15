
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DEFAULTDICT @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# defaultdict same as dict but have default value for nonexistent key
from collections import defaultdict

# setting int as default key type
d = defaultdict(int)
# d = defaultdict(float)
# d = defaultdict(list)

d['a'] = 1
d['b'] = 2

# on access of nonexistent key default value has been returned (0 in this case)
print(d['c'])

# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DEQUE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

# deque.. double ended que
from collections import deque

d = deque()

# deque methods

d.append(1)
d.append(2)
d.appendleft(3)

d.pop()
d.popleft()

d.clear()

# add to end
d.extend([4, 5, 6])
d.extendleft([7, 8, 9])

# rotate all units
d.rotate(2)
d.rotate(-2)
