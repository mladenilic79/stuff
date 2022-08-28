
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
dict1 = dict(one=1, two=2, three=3)
dict2 = dict(four=4, five=5, six=6, internal_dict=dict1)

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

# looping nested dictionary in another dictionary
for key2 in dict2:
    a = key2
    a = dict2[key2]
    internal_dict = dict2[key2]
    for key1 in internal_dict:
    # same as
    # for key1 in dict2[key2]
        a = key1
        a = internal_dict[key1]
        # same as
        # a = dict2[key2][key1]

# for creating iterator use iter or reversed
iterList1 = iter(list1)
iterList2 = reversed(list1)

# all data structures iterate the same
iterTuple = iter(tuple1)
iterRange = iter(range1)
iterString = iter(string1)
iterSet = iter(set1)
iterSetF = iter(frozenset1)
iterDict1 = iter(dict1)
# or
iterDict2 = iter(dict1.keys())

# call, returns default value instead of error if given
nextElement1 = next(iterList1)
nextElement2 = next(iterList1, "default value")
# or
nextElement3 = iterList1.__next__()
nextElement4 = iterList1.__next__()

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ FUNCTION GENERATORS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# A generator function returns a result when called
# They can be suspended and resumed during execution of your program to
# create results over time rather then all at once

# exapmle 1 simple

# generator function definition
def func_gen():
    print('This is printed first')
    yield 1

    print('This is printed second')
    yield 2

    print('This is printed at last')
    yield 3

# calling until it gets to next yield statement, pause execution and continue
# next time where it left off
execute = func_gen()
# get next element
a = next(execute)
# or
a = execute.__next__()

# or all at once
b = func_gen()
for i in b:
    print(i)

# example 2 with loop

# generator function definitions with loop
def iterate_through(iter):
    length = len(iter)
    for i in range(0, length, 1):
        yield iter[i]

# For loop through iterable
execute = iterate_through("perovic")
print(next(execute))
print(next(execute))
print(execute.__next__())
print(execute.__next__())

# or all at once
b = iterate_through("perovic")
for i in b:
    print(i)

# example 3 with loop

# with generator returning one element at the time instead of whole list
def firstn_generator(n):
    num = 0
    while num < n:
        yield num
        num += 1

a = firstn_generator(1000)
print(a.__next__())
print(a.__next__())
