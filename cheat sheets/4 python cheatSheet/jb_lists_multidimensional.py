
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LISTS MULTIDIMENSIONAL @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# list 10 x 10 blank
multiList = [[0] * 10 for i in range(10)]

# Change a value in the multidimensional list
multiList[0][1] = 10
# Get the item from the multidimensional list
a = multiList[0][1]

# populate multidimensional list
for i in range(10):
    for j in range(10):
        multiList[i][j] = "{} : {}".format(i, j)
        # for multiplication table put here instead
        # listTable[i][j] = i * j

# print multidimensional list
for i in range(10):
    for j in range(10):
        print(multiList[i][j], end=" || ")
    print()


# another example of multidimensional list
multiList2 = [[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]]

# print 1. row
print(multiList2[0])
# print 1. column
print([col[0] for col in multiList2])
# print diagonal
print([multiList2[i][i] for i in range(len(multiList2))])


# put all elements in one list (works for every similar type)
d = [list(range(10)), [1, 3, 5, 7, 9], ['a', 'b', 'c']]
listt = []
for x in d:
    for y in x:
        listt.append(y)

print(listt)
