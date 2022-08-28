
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LAMBDA @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@

# lambda is like def, but rather then assign the function to a name it just
# returns it. You can however assign a lambda function to a name.

# lambdas are used when you need a small function, but don't want to junk up
# your code with temporary function names that may cause conflicts

# This is their format
# lambda arg1, arg2,... : expression using the args

sum = lambda x, y: x + y
a = sum(4, 5)

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

print()

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS MAIN @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# What if you want code to execute when you run the script from the command
# line but not when the Python interpreter imports the file as module
# add this code to any script that you want to use both solo and as an import

# put all code in main method
def main():
    pass

# put this at the end of file/script/module
# special value of "__main__" for the __name__ variable means the
# Python interpreter is executing your script and not importing it
if __name__ == "__main__":
    main()

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ ANNOTATIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# It is possible to define the data types of attributes and the returned
# value with annotations, but they have no impact on how the function
# operates, but instead are for documentation

# define attribute types and annotation return type
def random_func(name: str, age: int, weight: float) -> str:
    print("Name :", name)
    print("Age :", age)
    print("Weight :", weight)
    return "{} is {} years old and weighs {}".format(name, age, weight)

print(random_func("Derek", 41, 165.5))
print()

# You don't get an error if you pass bad data
print(random_func(89, "Derek", "Turtle"))
print()

# You can print the annotations
annotations = random_func.__annotations__
