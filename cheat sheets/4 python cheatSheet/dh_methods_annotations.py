
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ METHODS ANNOTATIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# define the data types of attributes and the returned value but they have no impact on how the function operates, but instead are for documentation

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
print(annotations)
