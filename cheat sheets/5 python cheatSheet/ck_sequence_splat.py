
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SPLAT OPERATOR SPECIFICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

numbers = [1, 2, 3, 4, 5, 6]
my_typle = (1, 2, 3)
my_list = [4, 5, 6]
my_set = {7, 8, 9}

# packing / unpacking / repacking
*beginning, last = numbers
beginning, *last = numbers
beginning, *middle, last = numbers
beginning, *middle, secondlast, last = numbers
new_tuple = (*my_list, *my_typle, *my_set)
new_list = [*my_list, *my_typle, *my_set]
new_set = {*my_list, *my_typle, *my_set}

# dictionary operations
dict_a = {'a': 1, 'b': 2, 'c': 3, 'd': 4}
dict_b = {'c': 3, 'd': 4, 'a': 1, 'b': 2}
dict_c = {**dict_a, **dict_b}
