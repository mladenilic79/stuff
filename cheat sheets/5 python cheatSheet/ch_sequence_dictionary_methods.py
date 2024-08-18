
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DICTIONARY @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

dictionaryA = {'one': 1, 'two': 2, 'three': 3, 'four': 4, 'five': 5}
dictionaryD = dict(one=1, two=2, three=3)

# ---------- KEY METHODS ----------

# Update dictionary with data from other overwriting existing keys
dictionaryA.update(dictionaryD)

# returns all keys
keysList = list(dictionaryA)

# Add a new key value pair or change value
dictionaryA['city'] = 'Pittsburgh'

# remove and returns value else returns default
item1 = dictionaryA.pop("two")
item2 = dictionaryA.pop("seven", "default value")

# remove and return key value pair (tuple)
tuplePair1 = dictionaryA.popitem()

# If key is in the dictionary, return its value. If not, insert key
# with a value
item3 = dictionaryA.setdefault("one")
item4 = dictionaryA.setdefault("four", "default value")

# ---------- VALUE METHODS ----------

# get value
value = dictionaryA['one']

# get value return default if key doesn't exists
value1 = dictionaryA.get("one")
value2 = dictionaryA.get("seven", "default value")

# ---------- DYNAMIC VEIW METHODS ----------

# return keys
keys1 = dictionaryA.keys()
# iterate or convert to something

# return values
values1 = dictionaryA.values()
# iterate or convert to something

# return key value pairs
items1 = dictionaryA.items()
# iterate or convert to something
