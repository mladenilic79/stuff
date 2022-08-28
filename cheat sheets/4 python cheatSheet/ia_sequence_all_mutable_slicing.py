
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE ALL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# sequence examples (lists in this case)
variousList = ["string", 1.234, 28, "pera"]
oneToTen = list(range(10))

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
item = variousList[0]

# get min and max values
minn = min(oneToTen)
maxx = max(oneToTen)

# zip method (creates pairs of tuples)
a = ("John", "Charles", "Mike")
b = ("Jenny", "Christy", "Monica")
a = ["John", "Charles", "Mike"]
b = ["Jenny", "Christy", "Monica"]
zip_iterator_object = zip(a, b)
x = list(zip_iterator_object)
y = tuple(zip_iterator_object)
z = dict(zip_iterator_object)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE MUTABLE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# sequence examples (lists in this case)
variousList = ["string", 1.234, 28, "pera"]
oneToTen = list(range(10))

# You can change a list item
variousList[0] = "New String"

# slice of s from i to j is replaced by the contents of the iterable t
# oneToTen[1:3] = t
# s[i:j:k] = t

# Append a value to the end of a sequence
variousList.append("Another")

# Insert value at index: insert (index, value)
variousList.insert(5, 10)

# delete elements
del oneToTen[1:2]
oneToTen[1:2] = []

# Delete first occurrence of value
oneToTen.remove(8)

# Remove and returns item at index
# (if index not supplied than last item(index))
itemm = variousList.pop(2)

# remove all items from sequence
randomSequence = [1, 2, 3]
randomSequence.clear()
# or
randomSequence = [1, 2, 3]
del randomSequence[:]

# Reverse a list
variousList.reverse()

# updates s with its contents repeated n times
variousList *= 2

# extends s with the contents of t
variousList.extend(oneToTen)
variousList += oneToTen

# sorts list in place
variousList.sort()
# sort by creating new sorted list
new_list = sorted(variousList)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SEQUENCE SLICING @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

samp_string = "This is a very important string"

# You can get a character by referencing an index
slice = samp_string[0]

# Get the last character
slice = samp_string[-1]

# Get the character at index
slice = samp_string[3 + 5]

# Get a slice by saying where to start and end
# The 4th index isn't returned
slice = samp_string[0:4]

# Get everything starting at an index
slice = samp_string[8:]

# Get everything ending at an index
slice = samp_string[:4]

# Slice a sequence with a step, 2 in this example
slice = samp_string[0:10:2]
slice = samp_string[::3]
