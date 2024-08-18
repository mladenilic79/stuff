
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS EMBEDED @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

def func1():
    print("first function")

def func2(num1):
    print(num1)

def func3(num1, num2):
    return num1 + num2

# can be embeded in data structures
listOfFuncs = [func1, func2, func3]
c = listOfFuncs[2](6,5)
print(c)
