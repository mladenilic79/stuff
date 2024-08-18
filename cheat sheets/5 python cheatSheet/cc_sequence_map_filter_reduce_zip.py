
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS MAP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Map allows us to execute a function on each item in a list

oneTo10 = list(range(1, 11))

def dbl_num(num):
    return num * 2

# Pass in the function and the list to generate a new list, or use lambda
newList = list(map(dbl_num, oneTo10))
newList = list(map((lambda x: x * 2), oneTo10))

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS FILTER @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Filter selects items from a list based on a function

oneTo10 = list(range(1, 11))

def dbl_num(num):
    if num % 2 == 0:
        return True
    else:
        return False

# Print out the even values from a list, or use lambda
evenList = list(filter(dbl_num, oneTo10))
evenList = list(filter((lambda x: x % 2 == 0), oneTo10))

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS REDUCE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Reduce receives list and returns single result, rolling compute values in an iterable sequance, such as cumulative product of integer list, or cumulative sum
from functools import reduce

oneTo10 = list(range(1, 11))

def dbl_num(num, num_2):
    return num + num_2

# Add up the values in a list, or use lambda
result = reduce(dbl_num, oneTo10)
result = reduce((lambda x, y: x + y), oneTo10)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS ZIP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# zip method (creates pairs of tuples)
# convert to anything desired
a = ("John", "Charles", "Mike")
b = ["Jenny", "Christy", "Monica"]

zip_iterator_object = zip(a, b)
x = list(zip_iterator_object)
# prints [('John', 'Jenny'), ('Charles', 'Christy'), ('Mike', 'Monica')]

zip_iterator_object = zip(a,b)
y = tuple(zip_iterator_object)
# prints (('John', 'Jenny'), ('Charles', 'Christy'), ('Mike', 'Monica'))

zip_iterator_object = zip(a,b)
z = dict(zip_iterator_object)
# prints {'John': 'Jenny', 'Charles': 'Christy', 'Mike': 'Monica'}
