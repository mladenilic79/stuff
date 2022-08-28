
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP ADDING ITERATION ABILITY TO CLASS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# this topic is somewhat unclear how to use in practice

# example 1

class MainClass:

    def __init__(self,
                 iterable=(1, 2, 3, 4, 5)
                 ):

        self.iterable_variable = iterable
        self.index = len(iterable)

    # adding iterator capabilities to class
    def __iter__(self):
        return self

    # implementing _next_ method (implementing in reverse)
    def __next__(self):
        if self.index == 0:
            raise StopIteration
        self.index = self.index - 1
        return self.iterable_variable[self.index]


# instantiation
mainClass = MainClass()

# using implemented iteration on object
a = next(mainClass)
print(a)
print(type(a))
a = mainClass.__next__()
print(a)
# or all at once
for i in mainClass:
    a = i
    print(a)

print()
print()
print()

# exapmle 2

class TopTen:

    def __init__(self):
        self.num = 1

    def __iter__(self):
        return self

    def __next__(self):
        if self.num <= 10:
            val = self.num
            self.num += 1
            return val
        else:
            raise StopIteration

values = TopTen()

print(values.__next__())
print(values.__next__())
print(next(values))
print(next(values))

for i in values:
    print(i)
