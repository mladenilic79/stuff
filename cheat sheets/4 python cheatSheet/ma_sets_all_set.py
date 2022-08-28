
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SETS ALL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# set objects are an unordered collection of distinct hashable objects
# set is mutable (has no hash value)
# frozen set is immutable (has hash value)

# example iterable
list1 = [1, 2, 3, "c", "d"]

# constructors
# set = set(iterable)
# frozenset = frozenset(iterable)
set1 = {1, 2, 3, "c", "d"}
set2 = set(list1)
frozenset1 = frozenset(list1)
frozenset2 = frozenset(list1)

# returns length of set
lengthh = len(set1)

# You can see if a set contains or not an item
isContain = "string" in set1
isNotContain = "string" not in set1

# Sets are disjoint if their intersection is the empty set
isDisjoint = set1.isdisjoint(frozenset1)

# Test whether every element in the set is in other
isSubset = set1.issubset(frozenset1)
isSuperset = set1.issuperset(frozenset1)

# Return a new set with elements from the set and all others
unionSet1 = set1.union(frozenset1)
unionSet2 = set1.union(frozenset1, frozenset2)

# Return a new set with elements common to the set and all others
intersectionSet1 = set1.intersection(frozenset1)
intersectionSet2 = set1.intersection(frozenset1, frozenset2)

# Return a new set with elements in the set that are not in the others
differenceSet1 = set1.difference(frozenset1)
differenceSet2 = set1.difference(frozenset1, frozenset2)

# Return a new set with elements in either the set or other but not both
symmetric_difference1 = set1.symmetric_difference(frozenset1)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SETS SET @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# this do not apply to frozenset just to set

# example sequences and sets
list1 = [1, 2, 3]
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

# Remove element elem from the set
set1.remove(3)

# Remove element elem from the set
set1.discard(2)

# Remove and return an arbitrary element from the set
element1 = set1.pop()

# Remove all elements from the set
set1.clear()
