
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ GLOBAL VARIABLES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# any variable defined inside of a function is available only in that function

# you can't change a global variable even if it is passed into a function
# if you want to change global variable in method use global statement

global_var = "Sally"
def random_method():
    global_var = "Sammy" # unable to overright with this
random_method()
print(global_var)

global_var = "Sally"
def random_method():
    global global_var  # declare global variable inside the function
    global_var = "Sammy" # able to overright with this
random_method()
print(global_var)

# mutable objects such as lists can be changed if passed inside a function
# to redeclare mutable object you still need global statement

mas_list = [1, 2, 3]
def random_method(passed_list):
    passed_list.append(9) # able to edit with this
    passed_list = ["a", "b"] # unable to overright with this
random_method(mas_list)
print(mas_list)

mas_list = [1, 2, 3]
def random_method():
    global mas_list  # declare global variable inside the function
    mas_list.append(9) # able to edit with this
    mas_list =  ["a", "b"] # able to overright with this
random_method()
print(mas_list)
