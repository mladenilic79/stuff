
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ PASSING METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# pass function into another function
def add_numbers(num_1, num_2):
    return num_1 + num_2
def high_func(low_func, num4, num5):
    return low_func(num4, num5)
a = high_func(add_numbers, 4, 5)

# passing and returning methods
def parent(num):
    def first_child():
        return "Hi, I am Emma"
    def second_child():
        return "Call me Liam"
    if num == 1:
        return first_child
    else:
        return second_child
a = parent(5)
print(a())
