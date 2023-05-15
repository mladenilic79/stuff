
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ getters & setters @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class MainClass:

    def __init__(self,
                 instance_variable_private="private",
                 instance_variable_public="public",
                 instance_variable_protected="protected"):

        self.__instance_variable_private = instance_variable_private
        self._instance_variable_protected = instance_variable_protected
        self.instance_variable_public = instance_variable_public

    # all properties getters, setters & deleters can be added naknadno

    # getter classic
    def get_private_variable(self):
        return self.__instance_variable_private

    # setter classic
    def set_private_variable(self, random_variable):
        self.__instance_variable_private = random_variable

    # getter with property
    @property
    def instance_variable_private(self):
        return self.__instance_variable_private

    # setter with property
    @instance_variable_private.setter
    def instance_variable_private(self, random_variable):
        self.__instance_variable_private = random_variable

# instantiation
mainClass = MainClass()

# access attributes through getter & setter
a = mainClass.get_private_variable()
mainClass.set_private_variable("pera")

# access with property
a = mainClass.instance_variable_private
mainClass.instance_variable_private = "zdera"
