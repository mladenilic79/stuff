
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS NESTED @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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
nums = generated_func(3)

# version ii
def polynomial_creator(a, b, c):
    def polynomial(x):
        return a * x ** 2 + b * x + c
    return polynomial
p1 = polynomial_creator(2, 3, -1)
for x in range(-2, 2, 1):
    a = x
    b = p1(x)
