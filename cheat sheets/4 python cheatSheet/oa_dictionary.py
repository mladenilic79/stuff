
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DICTIONARY @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# example list
exampleList = [1, 2, 3, 4, 5]

# ---------- CREATING ----------

# constructors
dictionaryA = dict(one=1, two=2, three=3)
dictionaryB = {'one': 1, 'two': 2, 'three': 3}
dictionaryC = dict(zip(['one', 'two', 'three'], [1, 2, 3]))
dictionaryD = dict([('two', 2), ('one', 1), ('three', 3)])
dictionaryE = dict({'three': 3, 'one': 1, 'two': 2})
if dictionaryA == dictionaryB == dictionaryC == dictionaryD == dictionaryE:
    print()

# ---------- GENERAL METHODS ----------

# Dictionaries may print out in order created since they are unordered
# print(dictionaryA)

# dictionery length
dictLength = len(dictionaryA)

# returns shallow copy of a dictionary
newDictionary1 = dictionaryA.copy()

# returns copy with default value set to specified
newDictionary2 = dict.fromkeys(exampleList, "default value")

# Update dictionary with data from other overwriting existing keys
dictionaryA.update(dictionaryD)

# ---------- KEYS ----------

# returns all keys
keysList = list(dictionaryA)

# check for key
isKeyInDict1 = "one" in dictionaryA
isKeyInDict2 = "one" not in dictionaryA

# Add a new key value pair
dictionaryA['city'] = 'Pittsburgh'

# remove key from dictionary
del dictionaryA["three"]

# removes all items from dictionary
dictionaryB.clear()

# remove and returns value else returns default
item1 = dictionaryE.pop("two")
item2 = dictionaryE.pop("seven", "default value")

# remove and return key value pair (tuple)
tuplePair1 = dictionaryC.popitem()

# If key is in the dictionary, return its value. If not, insert key
# with a value and returns value
item3 = dictionaryD.setdefault("one")
item4 = dictionaryD.setdefault("four", "default value")

# ---------- VALUES ----------

# returns item
specifiedItem = dictionaryA["one"]

# returns value for specified key, else default
value1 = dictionaryA.get("one")
value2 = dictionaryA.get("seven", "default value")

# set new value for item
dictionaryA["one"] = 5

# ---------- DYNAMIC VIEWS ----------

# dynamic view on the dictionary’s entries, which means that
# when the dictionary changes, the view reflects these changes

keys1 = dictionaryA.keys()
# iterate or convert to list
keys_list = list(keys1)

values1 = dictionaryA.values()
# iterate or convert to list
values_list = list(values1)

items1 = dictionaryA.items()
# iterate or convert to dictionary
items_list = dict(items1)

# operation over views
lengthh = len(keys1)
isXInView = "one" in keys1
iterator3 = iter(keys1)
iterator4 = iter(values1)
iterator5 = reversed(items1)

# ---------- DICTIONARY COMPREHENSIONS ----------

# dict_variable = {key:value for (key,value) in dictonary.items()}

dict1 = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}

double_dict1 = {key: value*2 for (key,value) in dict1.items()}
dict1_keys = {key*2:value for (key,value) in dict1.items()}
