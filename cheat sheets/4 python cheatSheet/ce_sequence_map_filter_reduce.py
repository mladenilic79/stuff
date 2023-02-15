
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS MAP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Map allows us to execute a function on each item in a list

# list
oneTo10 = list(range(1, 11))

# The function to pass into map
def dbl_num(num):
    return num * 2

# Pass in the function and the list to generate a new list
newList = list(map(dbl_num, oneTo10))

# You could do the same thing with a lambda instead of function
newList = list(map((lambda x: x * 2), oneTo10))

# You can perform calculations against multiple lists
newList = list(map((lambda x, y: x + y), [1, 2, 3], [1, 2, 3]))

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS FILTER @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Filter selects items from a list based on a function

# list
oneTo10 = list(range(1, 11))

# Print out the even values from a list
evenList = list(filter((lambda x: x % 2 == 0), oneTo10))

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS REDUCE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Reduce receives list and returns single result (can be used instead of loop)
from functools import reduce

# list
oneTo10 = list(range(1, 11))

# Add up the values in a list
result = reduce((lambda x, y: x + y), oneTo10)
