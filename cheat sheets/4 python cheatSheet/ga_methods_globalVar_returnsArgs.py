
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# basic function, argument and default argument
def add_numbers(num_1, num_2=1, num_3=1):

    # docstring first string inside method that can be called with
    # method_name.__doc__
    """ this is docstring """

    # Return returns a value if needed else it will return none
    return num_1 + num_2 + num_3

# reassigning method
new_method = add_numbers

# calling method
aa = new_method(7)
a = add_numbers(1)
b = add_numbers(1, 2)
c = add_numbers(1, 2, 3)
# if using keyword arguments order is not important
# except positional arguments must go before keyword arguments
d = add_numbers(1, num_3=5)
# call docstring
e = "docstring: " + add_numbers.__doc__

# rename/reassign function
add_two_numbers = add_numbers

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ GLOBAL VARIABLES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Any variable defined inside of a function is available only in that function
# You can't change a global variable even if it is passed into a function
# If you want to change global variable in method use global statement

global_name = "Sally"

def change_name():
    global global_name  # declare global variable inside the function
    global_name = "Sammy"

change_name()

# mutable objects such as lists can be changed if passed inside a function

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RETURNS & ARGUMENTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# You can return multiple values with the return statement
def mult_divide(num_1, num_2):
    a = num_1 * num_2
    b = num_1 / num_2
    return a, b
    # or
    # tuplee = (a, b)
    # return tuplee
tuplee = mult_divide(5, 4)

# receive an unknown number of arguments using the splat (*) operator
def print_all(*args):
    a = type(args)
    for arg in args:
        a = arg
    return args
a = print_all(3, 4, 5)
b = print_all([3, 4, 5])
c = print_all((3, 4, 5))
d = print_all(*[3, 4, 5])
e = print_all(*(3, 4, 5))

# receive an unknown number of positional arguments using
# the double (**) operator, for dictionary
def print_all(**kwargs):
    a = type(kwargs)
    for key in kwargs:
        a = key
        a = kwargs[key]
    return kwargs
f = print_all(jedan=3, dva=4, tri=5)

# receive an unknown number of arguments using both (*, **) operators
# if function takes any arguments can be added like this
def print_all(arg1, *args, **kwargs):
    a = arg1
    a = args
    a = kwargs
    for arg in args:
        a = arg
    for key in kwargs:
        a = key
        a = kwargs[key]
a = print_all(3, 2, 8, 9, a=3, b=2, c=9)

# example: *args and just one keyword argument after it
def foo(*args, last):
    a = args
    a = last
foo(1, 2, 3, last=100)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SPLAT OPERATOR SPECIFICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# unpack with splat and double
# length of container must match number of parameters
def print_all(a, b, x):
    a = a
    a = b
    a = x
list = [1, 3, 5]
a = print_all(*list)
tuple = (1, 3, 5)
a = print_all(*tuple)
# for dictionary keys must match the names of the parameters
dict = {'a':'append', 'b':'block','x': 7}
a = print_all(*dict)
a = print_all(**dict)

# repacking and unpacking
numbers = [1, 2, 3, 4, 5, 6]
*beginning, last = numbers
beginning, *last = numbers
beginning, *middle, last = numbers
beginning, *middle, secondlast, last = numbers
###~> beginning = [1, 2, 3, 4, 5]
###~> last = 6

# merging
my_typle = (1, 2, 3)
my_list = [4, 5, 6]
my_set = {7, 8, 9}
new_list = [*my_list, *my_typle, *my_set]
# merging dictionary
dict_a = {'a': 1, 'b': 2}
dict_b = {'c': 3, 'd': 4}
dict_c = {**dict_a, **dict_b}

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SPECIAL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# after * all must be keyword arguments
def foo(a, b, *, c, d):
    a = a
    a = b
    a = c
    a = d
foo(1, 2, c=3, d=4)
