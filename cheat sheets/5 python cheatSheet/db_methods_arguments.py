
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS ARGUMENTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# default and keyword arguments
# if using keyword arguments order is not important except positional arguments must go before keyword arguments
def print_all(num_0=0, num_1=0, num_2=0):
    a = num_0 + num_1 + num_2
    # print(num_0 + num_1 + num_2)
a = print_all()
a = print_all(0)
a = print_all(0, 1)
b = print_all(1, 2, 3)
d = print_all(0, num_2=5, num_1=5)

# receive an unknown number of arguments using the splat (*) operator for tuple
def print_all(*args):
    for arg in args:
        a = arg
        # print(arg)
a = print_all(3, 4, 5)
d = print_all(*[3, 4, 5])
e = print_all(*(3, 4, 5))

# receive an unknown number of positional arguments using the double splat (**) operator for dictionary
def print_all(**kwargs):
    for key in kwargs:
        a = key
        a = kwargs[key]
        # print(key)
        # print(kwargs[key])
f = print_all(jedan=3, dva=4, tri=5)

# receive an unknown number of arguments using both (*, **) operators
# if function takes any arguments can be added like this
def print_all(positional1=0, *args, keywordArg1="", **kwargs):
    a = positional1
    # print(a)
    a = keywordArg1
    # print(a)
    a = args
    a = kwargs
    for arg in args:
        a = arg
        # print(arg)
    for key in kwargs:
        a = key
        a = kwargs[key]
        # print(key)
        # print(kwargs[key])
a = print_all(1, 2, 3, keywordArg1=4, a=1, b=2, c=3, d=4)
