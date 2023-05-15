
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class MainClass:

    # self allows an object to refer to itself (instance)
    # underscores are part of the name

    # The init method is called to create an object
    # We give default values for the fields if none are provided
    def __init__(self,
                 instance_variable_public="public",
                 instance_variable_protected="protected",
                 instance_variable_private="private"):
                 
        # private, means nobody can touch this from outside a class
        self.__instance_variable_private = instance_variable_private

        # protected by convention, means don't touch this unless you are writing a subclass
        self._instance_variable_protected = instance_variable_protected

        # public (from constructor)
        self.instance_variable_public = instance_variable_public
        # public (add fixed property / constant)
        self.graduationyear = 2019

        # calling method inside constructor and passing iterable inside
        self.instance_method_public(5)
        self._instance_method_protected(5)
        self.__instance_method_private(5)

    # public instance/object method
    def instance_method_public(self, random_variable):

        # access instance variables
        a = self.__instance_variable_private
        b = self._instance_variable_protected
        c = self.instance_variable_public

        # adding instance variable through instance method
        self.random_variable = random_variable

    # protected copy of instance method
    _instance_method_protected = instance_method_public

    # private method (all else the same as public method)
    def __instance_method_private(self, random_variable):
        pass

# instantiation
mainClass = MainClass()

# access instance variable
a = mainClass.instance_variable_public
a = mainClass._instance_variable_protected
# a = mainClass.__instance_variable_private # private will not work

# adding fiels to objects
mainClass.new_variable = "new variable"

# methods calling
mainClass.instance_method_public("random variable")
mainClass._instance_method_protected("random variable")
# mainClass.__instance_method_private("random variable") # private will not work
