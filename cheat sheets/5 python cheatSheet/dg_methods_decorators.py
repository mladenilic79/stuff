
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DECORATOR METHODS @@@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# decorator in Python is a callable Python object that is used to modify a function/method (or class definition)
# if multiple decorators are used they are executed in order listed, 1st decorator, they inside him 2nd decorator and so on..

# basic example without decorater property
def my_decorator(func):
    def wrapper():
        print("Something is happening before the function is called.")
        func()
        print("Something is happening after the function is called.")
    return wrapper

def say_whee():
    print("Whee!")

print()
say_whee = my_decorator(say_whee)
say_whee()
print()

# this import is only to properly identify method
import functools

# defining a decorator (can be used as template)
def my_decorator(func):
    # wrapper is a Wrapper function in which the argument is called
    # @functools.wraps is only to properly identify method and update special attributes
    @functools.wraps(func)
    # always put default arguments inside this function
    def wrapper(*args, **kwargs):
        # to do before
        print("Start")
        # calling the actual function now inside the wrapper function.
        result = func(*args, **kwargs)
        # to do after
        print("End")
        # returning inner function result
        return result
    return wrapper

# example 1: defining a function
@my_decorator
def print_name():
    print("Alex")

print_name()
print()

# exapmple 2: defining a function with a parameter & returned result
@my_decorator
def add5(x):
    return x + 5

print(add5(10))
print()

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
print()