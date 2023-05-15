
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TESTS BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

number = 4
assert number == 4
assert number == 4 and isinstance(number, int)

numbers = [1, 2, 3, 4, 5]
assert 4 in numbers

assert all([True, True, True])
assert any([False, True, False])
