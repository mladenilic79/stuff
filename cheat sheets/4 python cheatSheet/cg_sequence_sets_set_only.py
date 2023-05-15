
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SETS SET @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# set objects are an unordered collection of distinct hashable objects
# set is mutable (has no hash value)
# frozen set is immutable (has hash value)
# this applies just to set

list1 = [1, 2, 3]

# constructors
set1 = {1, 2, 3, "c", "d"}
set1 = set(list1)
set2 = set(list1)
set3 = set(list1)

# Update the set, adding elements from all others
updatedSet = set1.update(set2, set3)

# Update the set, keeping only elements found in it and all others
updatedSetIntersection = set1.intersection_update(set2, set3)

# Update the set, removing elements found in others
updatedSetDifference = set1.difference_update(set2, set3)

# Update the set, keeping only elements found in either set, but not in both
updatedSetSymmetricDifference = set1.symmetric_difference_update(set2)

# Add element elem to the set
set1.add("pera")

# Remove element elem from the set, will not raise error
set1.discard(2)
