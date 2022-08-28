
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class MainClass:

    # self allows an object to refer to itself (instance)
    # underscores are port of the name

    # class/static variables
    public_class_variable = 0
    __private_class_variable = 0

    # The init method is called to create an object
    # We give default values for the fields if none are provided
    def __init__(self,
                 instance_variable_private="private",
                 instance_variable_public="public",
                 instance_variable_protected="protected"):

        # private, means nobody can touch this from outside a class
        self.__instance_variable_private = instance_variable_private

        # protected by convention, means don't touch this unless
        # you are writing a subclass
        self._instance_variable_protected = instance_variable_protected

        # public
        self.instance_variable_public = instance_variable_public

        # add fixed property
        self.graduationyear = 2019

        # class/static variables usefull for counters
        MainClass.public_class_variable += 1

        # calling method inside constructor and passing iterable inside
        self.public_instance_method(5)
        self.__instance_method(5)

    # public instance/object method
    def public_instance_method(self, random_variable):

        # access instance variables
        a = self.__instance_variable_private
        b = self._instance_variable_protected
        c = self.instance_variable_public

        # static/class variable unique to class / to all instances
        d = MainClass.public_class_variable

        # static/class varibale can be also redeclared in any instance
        self.public_class_variable = 9

        # adding instance variable through instance method
        self.random_variable = random_variable

    # private method (all else the same as public method)
    def __private_instance_method(self, random_variable):

        pass

    # private copy of instance method
    __instance_method = public_instance_method

    # static methods are like in java
    @staticmethod
    def static_method(set_class_variable, new_class_variable, random_variable):
        # access class variable
        a = MainClass.__private_class_variable

        # setting class variable
        MainClass.__private_class_variable = set_class_variable

        # set new class variable
        MainClass.new_class_variable = new_class_variable

        # creating new instance/object through static method
        new_object = MainClass(random_variable)
        return new_object

    # class methods are like static methods but they are bound to class &
    # receive class as first arg
    @classmethod
    def class_method(cls, set_class_variable, new_class_variable,
                     random_variable):

        # accessing class/static variable
        a = cls.public_class_variable

        # setting class variable
        cls.public_class_variable = set_class_variable

        # new class variable instantiation inside class method
        cls.new_class_variable = new_class_variable

        # creating new instance/object through class method
        new_object = cls(random_variable)
        return new_object

    # all properties getters, setters & deleters can be added naknadno

    # getter (access function in main like an argument without parenthesis)
    @property
    def instance_variable_private(self):
        return self.__instance_variable_private

    # getter, same as:
    # def instance_variable_private(self):
    #     return self.__instance_variable_private
    # instance_variable_private = property(instance_variable_private)

    # setter (access function in main like an argument without parenthasis)
    @instance_variable_private.setter
    def instance_variable_private(self, instance_variable_private):
        self.__instance_variable_private = instance_variable_private

    # deleter (access function in main like an argument without parenthasis)
    @instance_variable_private.deleter
    def instance_variable_private(self):
        self.__instance_variable_private = None

    # str magic method can be used to cast our object as a string
    # type(self).__name__ returns the class name
    def __str__(self):
        return "A {} is {} it is {}".format(type(self).__name__,
                                            self.instance_variable_private,
                                            self.__instance_variable_private,
                                            self._instance_variable_protected,
                                            self.instance_variable_public)


# instantiation
mainClass = MainClass()

# class variable
a = MainClass.public_class_variable
a = mainClass.public_class_variable

# direct access to attributes
a = mainClass.instance_variable_public

# access attributes through getter & setter
a = mainClass.instance_variable_private
mainClass.instance_variable_private = "perovic"

# adding field to classes & objects
mainClass.new_field = "new instance field"
MainClass.new_field = "new class field"

# methods calling
mainClass.public_instance_method("random variable")
MainClass.public_instance_method(mainClass, "random variable")
mainClass.class_method(3, "random var 2", "random var 3")
mainClass.static_method(3, "random var 2", "random var 3")

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# object id
x = 3
a = id(x)

# calling to string __str__
print(mainClass)

# check if is instance
is_instance = isinstance(mainClass, MainClass)

# deleting object
# del mainClass

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ BUILTINS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# returns all attributes & methods of local scope
b = dir()
print(b)

# returns all attributes & methods of passed object
c = dir(mainClass)
print(c)

# returns all builtin names
import builtins
d = dir(builtins)
print(d)

# returns all attributes of object or class
e = MainClass.__dict__
f = mainClass.__dict__
print(e)
print(f)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ EMPTY CLASS DEFINITION USAGE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# empty class definition
class Employee:
    pass

# creating empty record
john = Employee()

# Fill the fields of the record
john.name = 'John Doe'
john.dept = 'computer lab'
john.salary = 1000
