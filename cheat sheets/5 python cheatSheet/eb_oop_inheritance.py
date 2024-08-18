
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP INHERITANCE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# a class will inherit all of the fields and methods from another class
# That class is the subclass and the class we inherit from is the super class
# You can inherit from multiple classes by separating them with a comma

from ea_oop_class import MainClass

# diamond problem is if there is a multiple inheritance diamond shaped, method called will be from first class mentioned
# You can use super() to refer to the superclass

class SubClass(MainClass):

    # add init in subclass to override init from superclass
    # if you skip init, init from super class will be called automatically
    def __init__(self, instance_variable_public="warm blooded", instance_variable_protected="born alive", 
                 instance_variable_private="blood sucker", instance_variable_public_added="vampire"):

        # Calling init from super class
        # when using super() you don't need self argument
        super().__init__(instance_variable_public, instance_variable_protected, instance_variable_private)
        # or use without super, also maybe easier if using multiple inheritance:
        # MainClass.__init__(self, instance_variable_public, instance_variable_protected, instance_variable_private)

        # these is not needed, it is called by the super().__init__
        # self.instance_variable_public = instance_variable_public
        # self._instance_variable_protected = instance_variable_protected
        # self.__instance_variable_private = instance_variable_private
        # everything not redefinded in sub class will be taken from base class
        
        # instantiate missing variable
        self.instance_variable_public_added = instance_variable_public_added

    # overwriting instance method (must match parameters from super)
    def instance_method_public(self, random_variable):
        pass

    # calling parent method from subclass, use super keyword
    def calling_super_method(self):
        super().instance_method_public("random variable")

# instantiation
subClass = SubClass()

# access attributes
a = subClass.instance_variable_public
a = subClass._instance_variable_protected
# a = subClass.__instance_variable_private # private is not going to work here

# calling instance method
subClass.instance_method_public("random variable")
# calling super method
subClass.calling_super_method()
