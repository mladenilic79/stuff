
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP ABSTRACT CLASSES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Abstract classes are classes that contain one or more abstract methods. An
# abstract method is a method that is declared, but contains no implementation.
# Abstract classes cannot be instantiated, and require subclasses to provide
# implementations for the abstract methods

from abc import ABC, abstractmethod


# abstract class
class AbstractClassExample(ABC):

    @abstractmethod
    def __init__(self):
        pass

    @abstractmethod
    def do_something(self):
        pass


# abstract class implementation
class AbstractClassImplementation(AbstractClassExample):

    def __init__(self, value):
        self.value = value

    def do_something(self, passed):
        print(passed)


implementedObject = AbstractClassImplementation(10)
a = implementedObject.do_something(implementedObject.value)
