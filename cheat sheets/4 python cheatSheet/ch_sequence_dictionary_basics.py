
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ DICTIONARY @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

exampleList = [1, 2, 3, 4, 5]

# ---------- CONSTRUCTORS ----------

dictionaryA = {'one': 1, 'two': 2, 'three': 3}
dictionaryB = dict([('two', 2), ('one', 1), ('three', 3)])
dictionaryC = dict({'three': 3, 'one': 1, 'two': 2})
dictionaryD = dict(one=1, two=2, three=3)
dictionaryE = dict(zip(['one', 'two', 'three'], [1, 2, 3]))
# Create a new dictionary with keys from iterable and values set to value
dictionaryF = dict.fromkeys(exampleList, "default value")

if dictionaryA == dictionaryB == dictionaryC == dictionaryD == dictionaryE:
    print("all good")
