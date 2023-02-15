
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE CONVERSIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Conversion: List - Tuple
aList = [55, 89, 144]
aTuple = tuple(aList)
aList = list(aTuple)

# Conversion: List - Set
aSet = set(aList)
aList = list(aSet)

# Conversion: Tuple - Set
aTuple = tuple(aSet)
aSet = set(aTuple)

# Turn a list into a string (separate items with the defined separator)
listt = ["Bunch", "of", "random", "words"]
stringg = " ".join(listt)

# Convert a string (a sentence) into a list of words
listt = stringg.split()

# Convert a string (a sentence) into a list of lines
listtt = stringg.splitlines()
