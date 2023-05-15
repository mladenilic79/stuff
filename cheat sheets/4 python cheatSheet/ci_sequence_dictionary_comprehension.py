
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DICTIONARY COMPREHENSIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# dict_variable = {key:value for (key,value) in dictonary.items()}

dict1 = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}

double_dict1 = {key: value*2 for (key,value) in dict1.items()}
dict1_keys = {key*2:value for (key,value) in dict1.items()}
