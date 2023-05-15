
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ ITERABLES & ITERATORS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# iterable is is a stored sequence of values (list, tuple,..), an object with
# an __iter__ method which returns an iterator.
# An iterator is an object with a __next__ method which retrieves the next
# value from sequence of values
# you can only iterate once per iterator instantiation, to repeat you have to
# declare new instance of iter

list1 = ["string", 1.234, 28, "pera"]
tuple1 = (1, "pera", 3, 5, 8)
range1 = range(10)
string1 = "This is a very important string"
set1 = set(list1)
frozenset1 = frozenset(list1)
dict1 = dict(one=1, two=2, three=3, four=4, five=5, six=6)

# all data structures looping in the same way
for i in list1:
    a = i
for i in tuple1:
    a = i
for i in range1:
    a = i
for i in string1:
    a = i
for i in set1:
    a = i

# looping dict
for key in dict1:
    a = key
    b = dict1[key]
for i, j in dict1.items():
    a = i
    b = j

# for creating iterator use iter or reversed for reverse iteration
iterList = reversed(list1)
iterTuple = iter(tuple1)
iterRange = iter(range1)
iterString = reversed(string1)
iterSet = iter(set1)
iterSetF = iter(frozenset1)
iterDict = iter(dict1)

# call, returns default value instead of error if given
nextElement1 = next(iterList)
nextElement2 = next(iterList, "default value")
# or
nextElement3 = iterList.__next__()
nextElement4 = iterList.__next__()
