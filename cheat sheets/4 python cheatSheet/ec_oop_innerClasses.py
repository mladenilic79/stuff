
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP INNER CLASSES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class Outer:

    def __init__(self, outer_var, random_var):
        self.outer_var = outer_var
        self.inner = self.Inner(random_var)

    def show(self):
        print(self.outer_var)
        self.inner.show()

    class Inner:

        def __init__(self, inner_var):
            self.inner_var = inner_var

        def show(self):
            print(self.inner_var)


outer = Outer('Navin', 'peshi')

outer.show()

# accessing inner class elements
inner_attribute = outer.inner.inner_var
inner_method = outer.inner.show()

# creating object from inner class directly
direct = Outer.Inner(3)
