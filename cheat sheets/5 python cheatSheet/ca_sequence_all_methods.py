
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE ALL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# mutable: list, dictionary, set
# immutable: string, tuple, range, frozenset

# sequence examples (lists in this case)
variousList = ["string", 1.234, 28, "pera"]
oneToTen = list(range(10))

# membership operators
# in & not in
element = "string" in variousList # True
element = "string" not in variousList # False

# Get the length
listLength = len(variousList)

# Combine sequence
bigList = variousList + oneToTen

# You can repeat a sequence
repeatedList = variousList * 3
repeatedList2 = 3 * variousList

# You can see if a sequence contains or not an item
isContain = "string" in variousList
isNotContain = "string" not in variousList

# Find out how many times an item is in the sequence
countt = variousList.count("string")

# index of the first occurrence of x in s
# (at or after index i and before index j)
indexx1 = bigList.index("pera")
indexx2 = bigList.index("pera", 2, 5)

# Get the item with an index
item = variousList[1]

# get min and max values
minn = min(oneToTen)
maxx = max(oneToTen)
