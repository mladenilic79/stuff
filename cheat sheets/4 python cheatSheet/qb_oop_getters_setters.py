
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP GETTERS & SETTERS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# javaesque way
class P:

    # constructor
    def __init__(self,x):
        self.__x = x

    # getter
    def get_x(self):
        return self.__x

    # setter
    def set_x(self, x):
        self.__x = x


# pythonic way
class R:

    def __init__(self,x):
        self.x = x


# pythonic way with encapsulation (recommended way to do it)
class S:

    def __init__(self,x):
        self.x = x

    @property
    def x(self):
        return self.__x

    @x.setter
    def x(self, x):
        if x < 0:
            self.__x = 0
        elif x > 1000:
            self.__x = 1000
        else:
            self.__x = x


# pythoic way with encapsulation but without decorators (not recomended)
class T:

    def __init__(self,x):
        self.set_x(x)

    def get_x(self):
        return self.__x

    def set_x(self, x):
        if x < 0:
            self.__x = 0
        elif x > 1000:
            self.__x = 1000
        else:
            self.__x = x

    x = property(get_x, set_x)


# pythoic way with encapsulation but without decorators & with private methods
# (not recomended)
class U:

    def __init__(self,x):
        self.__set_x(x)

    def __get_x(self):
        return self.__x

    def __set_x(self, x):
        if x < 0:
            self.__x = 0
        elif x > 1000:
            self.__x = 1000
        else:
            self.__x = x

    x = property(__get_x, __set_x)
