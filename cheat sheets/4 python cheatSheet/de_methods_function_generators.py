
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
