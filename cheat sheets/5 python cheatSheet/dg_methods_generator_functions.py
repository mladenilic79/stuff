
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ FUNCTION GENERATORS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# a generator function returns a result when called
# they can be suspended and resumed during execution of your program to create results over time rather then all at once

# ---------- exapmle 1 simple ----------

def function_generator():
    print('This is printed first')
    yield 1
    print('This is printed second')
    yield 2
    print('This is printed at third')
    yield 3

# calling until it gets to next yield statement, pause execution and continue next time where it left off
executee = function_generator()
# get next yield value
yieldd = next(executee)
# or to the next yield value
yieldd = executee.__next__()

# or get all values at once in a loop
executee = function_generator()
# iterate through yields
for yieldd in executee:
    a = yieldd

# ---------- example 2 with for each loop ----------

def function_generator(sequence1):
    length = len(sequence1)
    for i in range(0, length):
        yield sequence1[i]

executee = function_generator("stringg")
yieldd = next(executee)
yieldd = next(executee)
yieldd = executee.__next__()
yieldd = executee.__next__()

executee = function_generator("stringg")
for yieldd in executee:
    a = yieldd

# ---------- example 3 with while loop ----------

def function_generator(n):
    num = 0
    while num < n:
        yield num
        num += 1

executee = function_generator(1000)
yieldd = next(executee)
yieldd = next(executee)
yieldd = executee.__next__()
yieldd = executee.__next__()

executee = function_generator(5)
for yieldd in executee:
    a = yieldd
