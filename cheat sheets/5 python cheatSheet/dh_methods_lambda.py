
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LAMBDA @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

# lambda is like def, but rather then assign the function to a name it just
# returns it. You can however assign a lambda function to a name.

# lambdas are used when you need a small function, but don't want to junk up
# your code with temporary function names that may cause conflicts

x = lambda a : a + 10
a = x(5)

x = lambda a, b : a * b
a = x(5, 6)

can_vote = lambda age: True if age >= 18 else False
b = can_vote(16)

# Create a list of functions
powerList = [lambda x: x ** 2,
             lambda x: x ** 3,
             lambda x: x ** 4]
# Run each function on a value
for func in powerList:
    c = func(4)

# You can also store lambdas in dictionaires
attack = {'quick': (lambda: print("Quick Attack")),
          'power': (lambda: print("Power Attack")),
          'miss': (lambda: print("The Attack Missed"))}
attack['quick']()
