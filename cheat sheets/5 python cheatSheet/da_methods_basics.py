
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# basic function
def add_numbers(num_1, num_2):

    # docstring first string inside method that can be called with
    # method_name.__doc__
    """ this is docstring """

    # Return returns a value if needed else it will return none
    return num_1 + num_2

# calling method
b = add_numbers(1, 2)

# call docstring
e = "docstring: " + add_numbers.__doc__
