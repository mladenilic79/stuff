
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP INHERITANCE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# a class can inherit all of the fields and methods from another class
# That class is the subclass and the class we inherit from is the super class
# You can inherit from multiple classes by separating them with a comma

from qa_oop_basics_methods_builtins_empty import MainClass

# in diamond problem if there is a multiple inheritance like so:
# class SubClass(MainClass, SecondClass):
# method called will be from first class mentioned

class SubClass(MainClass):

    # add init in subclass to override init from superclass
    # if you skip init, init from super class will be called automatically
    def __init__(self,
                 instance_variable_private="born alive",
                 instance_variable_public="warm blooded",
                 instance_variable_added=True):

        # Calling init from super class
        super().__init__(instance_variable_private, instance_variable_public)
        # or use:
        # MainClass.__init__(self, instance_variable_private, instance_variable_public)

        # instantiate missing variable
        self.__instance_variable_added = instance_variable_added

        # add fixed property
        self.graduationyear = 2020

    # We can extend the subclasses (add setters & getters)
    @property
    def instance_variable_added(self):
        return self.__instance_variable_added

    @instance_variable_added.setter
    def instance_variable_added(self, instance_variable_added):
        self.__instance_variable_added = instance_variable_added

    # Overwrite __str__ (to string like method)
    # You can use super() to refer to the superclass
    def __str__(self):
        return super().__str__() + " and it is {} they nurse " \
                                   "their young".format(self.instance_variable_added)

    # overwriting instance method (must match parameters from super)
    def public_instance_method(self, random_variable):
        pass

    # calling super class methods
    def calling_super(self):
        super().public_instance_method("random variable")

# instantiation
subClass = SubClass()

# getter & setter
a = subClass.instance_variable_added
subClass.instance_variable_added = "simovic"

# calling instance method
b = subClass.public_instance_method("random variable")

# calling instance method from super class
c = MainClass.public_instance_method(subClass, "random variable")
c = super(SubClass, subClass).public_instance_method("random variable")

# calling super class/method
d = subClass.calling_super()

# check if is subclass
is_this_a_subclass = issubclass(SubClass, MainClass)
