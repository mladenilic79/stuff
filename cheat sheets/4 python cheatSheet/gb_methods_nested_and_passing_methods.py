
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS NESTED & PASSING METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

def add_numbers(num_1, num_2):
    return num_1 + num_2

# pass function into another function
def high_func(low_func, num4, num5):
    return low_func(num4, num5)
a = high_func(add_numbers, 4, 5)

# nested method
def function1():
    print ("Hello from outer function")
    def function2():
        print ("Hello from inner function")
    function2()
function1()

# pass value & return value from another function
def outer_method(a):
    def inner_method(b):
        return a * b
    return inner_method
generated_func = outer_method(2)
b = generated_func(3)

# version ii
def polynomial_creator(a, b, c):
    def polynomial(x):
        return a * x ** 2 + b * x + c
    return polynomial
p1 = polynomial_creator(2, 3, -1)
for x in range(-2, 2, 1):
    a = x
    b = p1(x)

# can be embeded in data structures
listOfFuncs = [add_numbers, high_func, function1, generated_func]
c = listOfFuncs[0](9,5)
