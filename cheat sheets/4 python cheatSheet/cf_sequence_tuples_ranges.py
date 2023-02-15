
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TUPLES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

# A Tuple is like a list, but their values can't be changed
# Tuples are surrounded with parentheses instead of square brackets

# fixed
fixedTuple = (1, "pera", 3, 5, 8)
fixedTuple0 = 1, "pera", 3, 5, 8
fixedTuple1 = ()
# single item tuple
fixedTuple2 = ("sima",)
fixedTuple3 = "sima",
# constructor
oneToTen = tuple(range(10))
tuple4 = tuple()

# unpacking tuple
el1, el2, el3, el4, el5 = fixedTuple
# or with * , whick will unpack all other items and store it in a list
el1, *el2, el3 = fixedTuple

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RANGES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ranges for range of numbers
# taking small amount of memory compared to tuples & lists
# used for looping

# with stop only
range1 = range(10)
# and with start
range2 = range(3, 10)
# and with start & step (positive or negative)
range3 = range(3, 10, 2)
# all negative
range4 = range(42,-12,-7)
