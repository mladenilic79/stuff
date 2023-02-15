
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ COPYING ASSIGNMENT SHALLOW DEEP @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import copy

# works on all objects: lists, sets, dictionaries,...

old_list = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

# copy using assignment = (original list, all nested objects original also)
list1 = old_list
# shallow copy (one level deep, copy of list, all nested objects original)
list2 = copy.copy(old_list)
list2 = old_list.copy()
list2 = list(old_list)
list2 = old_list[:]
# deep copy (copy all levels, copy of list, all nested objects copied)
list3 = copy.deepcopy(old_list)

old_list.append("nulti")
list1.append("prvi")
list2.append("drugi")
list3.append("treci")

print(old_list)
print(list1)
print(list2)
print(list3)
