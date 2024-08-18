
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class MainClass:

    # underscores are part of the name

    # static/class variables
    static_variable_public = 0
    _static_variable_protected = 0
    __static_variable_private = 0

    def __init__(self):

        # class variables usefull for counters
        MainClass.static_variable_public += 1
        MainClass._static_variable_protected += 1
        MainClass.__static_variable_private += 1

    # public instance/object method
    def instance_method_public(self):

        # using static/class variable
        d = MainClass.static_variable_public

        # redeclared static/class variable as instance variable
        self.static_variable_public = 9

    # instance methods are bound to instance
    # class methods are bound to class, useful for factory pattern
    # static methods are unbound like static variables just like in java

    @classmethod
    def class_method(cls, set_class_variable, new_class_variable):

        # access class variable
        a = cls.static_variable_public
        a = cls._static_variable_protected
        a = cls.__static_variable_private

        # setting class variable
        cls.static_variable_public = set_class_variable

        # adding new class variable
        cls.static_variable_public_1 = new_class_variable

        # creating new instance/object through class method, factory pattern
        new_object = cls()
        return new_object

    @staticmethod
    def static_method(set_static_variable, new_static_variable):

        # access class variable
        a = MainClass.static_variable_public
        a = MainClass._static_variable_protected
        a = MainClass.__static_variable_private

        # setting static variable
        MainClass.static_variable_public = set_static_variable

        # set new static variable
        MainClass.static_variable_public_1 = new_static_variable


mainClass = MainClass()

# access class variable
a = MainClass.static_variable_public
a = MainClass._static_variable_protected
# a = MainClass.__static_variable_private # private will not work

# create new variable
MainClass.static_variable_public_2 = 17

# creating instance copy of static/class variables
a = mainClass.static_variable_public
a = mainClass._static_variable_protected
# a = mainClass.__static_variable_private # private will not work

# methods calling
MainClass.class_method(55, 77)
MainClass.static_method(55, 77)
