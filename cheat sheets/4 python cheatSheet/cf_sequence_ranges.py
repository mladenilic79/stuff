
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RANGES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ranges for range of numbers
# taking small amount of memory compared to tuples & lists
# used for looping

# with stop only
range1 = range(10)
print(list(range1))

# and with start and stop
range1 = range(3, 10)
print(list(range1))

# and with start and stop and step (positive or negative)
range1 = range(3, 10, 2)
print(list(range1))
# and negative

range1 = range(-42,-12,7)
print(list(range1))