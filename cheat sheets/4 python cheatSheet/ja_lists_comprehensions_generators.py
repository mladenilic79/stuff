
# @@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@

# By default the 1st item in a list has the index 0
# Python lists can grow in size and can contain data of any type

# create from another iterable (like range) with constructor or fixed
# list = list(iterable)
oneToTen = list(range(10))
fiveToTen = list(range(5, 10))
emptyList1 = list()
variousList = ["string", 1.234, 28, "pera"]
emptyList2 = []

# Sort a list
oneToTen.sort()

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS COMPREHENSIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# A list comprehension executes an expression against an iterable
# list comprehension is surrounded by [] because it returns a list
# A list comprehension can act as map and filter on one line

rangeList = list(range(1, 11))
fixedList = [1, 2, 3, 4, 5]

# Perform an operation on each item in the list
listt = [x * 2 for x in rangeList]
listt2 = [x for x in range(1, 11) if x % 2 != 0]

# list of lists (multidimensional list)
multiList = [[m * 2, m * 3, m * 4] for m in fixedList]

# You can have multiple for loops as well
# Multiply all values in one list times all values in another
multipleFor = [x * y for x in range(1, 3) for y in range(11, 16)]

# You can put list comprehensions in list comprehensions
nestedComprehension = [x * 3 for x in [i * 2 for i in range(10)] if x % 4 == 0]

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ COMPREHENSIONS GENERATORS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Generator expressions look just like list comprehensions
# but they return results only once, have to be created again to call again
# The are surrounded by parentheses instead of [ ]

my_list = [1, 3, 6, 10]

a = (x**2 for x in my_list)

# return one at a time (print first and second)
print("Double :", next(a))
print("Double :", next(a))
# and does not start from beginning (print third and fourth)
for i in a:
    print(i)
