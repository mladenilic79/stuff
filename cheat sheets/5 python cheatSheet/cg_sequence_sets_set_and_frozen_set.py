
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SETS & FROZENSETS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# set objects are an unordered collection of distinct hashable objects
# set is mutable (has no hash value)
# frozen set is immutable (has hash value)
# this applies to both set and frozenset

list1 = [1, 2, 3, "c", "d"]

# constructors
set1 = {1, 2, 3, "c", "d"}
set2 = set(list1)
frozenset1 = frozenset(list1)
frozenset2 = frozenset({1, 2, 3, "c", "d"})

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

# Return a new set with elements in either the set but not both (so all except intersection)
symmetric_difference1 = set1.symmetric_difference(frozenset1)
