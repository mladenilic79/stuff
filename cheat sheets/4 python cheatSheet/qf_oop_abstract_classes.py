
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

    def __init__(self, value):
        self.value = value
        super().__init__()

    @abstractmethod
    def do_something(self):
        pass


# abstract class implementation
class DoAdd42(AbstractClassExample):

    def do_something(self):
        return self.value + 42


x = DoAdd42(10)
print(x.do_something())
