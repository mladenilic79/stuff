
# decorator in Python is a callable Python object that is used to modify a
# function/method or class definition

# tipical use cases are timer decorator for execution time, debug decorator for
# additional arguments

# if multiple decorators are used they are executed in order listed
# 1st decorator, they inside him 2nd decorator and so on..

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DECORATOR METHODS NO PARAMETER @@@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# this import is only to properly identify method
import functools

# defining a decorator (can be used as template)
def my_decorator(func):

    # wrapper is a Wrapper function in which the argument is called
    # @functools.wraps is only to properly identify method
    @functools.wraps(func)
    # always put default arguments inside this function
    def wrapper(*args, **kwargs):
        # to do before
        # print("Start")
        # calling the actual function now inside the wrapper function.
        result = func(*args, **kwargs)
        # to do after
        # print("End")
        # returning inner function result
        return result
    return wrapper

# example 1: defining a function
@my_decorator
def print_name():
    print("Alex")
print_name()

# assigning a decorator regularly instead of decorator
# print_name = start_end_decorator(print_name)

# exapmple 2: defining a function with a parameter & returned result
@my_decorator
def add5(x):
    return x + 5
result = add5(10)
print(result)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DECORATOR METHODS WITH PARAMETER @@@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# one more layer of nested method for passing additional parameter
def repeat(num_times):
    def decorator_repeat(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            for _ in range(num_times):
                result = func(*args, **kwargs)
            return result
        return wrapper
    return decorator_repeat

@repeat(num_times=3)
def greet(name):
    print(f'Hello {name}')

greet('Alex')

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DECORATOR CLASSES @@@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# class decorators are same as function decorators but are typically used for
# maintaining and updating a state

class CountCalls:

    # init is just like the decorator function
    def __init__(self, func):
        self.func = func
        self.num_calls = 0

    # same as inner function in function decorator
    def __call__(self, *args, **kwargs):
        self.num_calls +=1
        print(f'This is executed {self.num_calls} times')
        return self.func(*args, **kwargs)

@CountCalls
def say_hello():
    print('Hello')

say_hello()
say_hello()
