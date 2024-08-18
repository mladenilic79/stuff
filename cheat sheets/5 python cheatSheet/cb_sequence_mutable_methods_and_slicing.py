
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE MUTABLE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# list, dictionary, set

# sequence examples (lists in this case)
variousList = ["string", "strana", 28, "pera"]
oneToTen = list(range(10))

# You can change an item or multiple items
variousList[0] = "New String"
variousList[0:2] = ["New Strings", "sima", "olga"]

# Append a value to the end of a sequence
variousList.append("Another")

# Insert value at index: insert (index, value)
variousList.insert(5, "sto")

# updates with its contents repeated n times
variousList *= 2

# extends s with the contents of t
variousList.extend(oneToTen)
variousList += oneToTen

# delete elements using slicing
del oneToTen[1:2]
variousList[14:40] = []

# Delete first occurrence of value
variousList.remove(28)

# Remove and returns item at index
# (if index not supplied than last item(index))
itemm = variousList.pop(9)

# remove all items from sequence
oneToTen.clear()

# can remove any object, part of list, or dictionary key
del oneToTen[:]
# del dictionaryA["three"]

# Reverse a list
variousList.reverse()

# sorts list in place
variousList.sort()
# sort by creating new sorted list
new_list = sorted(variousList)
