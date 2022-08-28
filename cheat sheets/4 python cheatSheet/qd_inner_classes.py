
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP INNER CLASSES @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

class Student:

    def __init__(self, first_name, last_name, ram):
        self.first_name = first_name
        self.last_name = last_name
        self.lap = self.Laptop(ram)

    def show(self):
        print(self.first_name, self.last_name)
        self.lap.show()

    class Laptop:

        def __init__(self, ram):
            self.brand = "Hp"
            self.cpu = 'i5'
            self.ram = ram

        def show(self):
            print(self.brand,self.cpu,self.ram)


student = Student('Navin', 'peshi', 2)

student.show()

# creating object from inner class directly
laptop = Student.Laptop(3)

# accessing inner class object
lap = student.lap
