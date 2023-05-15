
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP MAGIC/DUNDER METHODS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# __str__
# __repr__
# __dict__
# __file__

# We can use magic methods to define operator overloading and redefining how
# various python methods work which is important for oop


class Employee: 
    def __init__(self, name, age, id): 
        self.name = name 
        self.age = age
        self.id = id 

    # override default str method
    def __str__(self):
        return f'Employee name is {self.name}, employee\'s age is {self.age} and id is {self.id}'
    
    # override default repr method
    def __repr__(self):
        return f'Employee(name = {self.name}, age = {self.age}, id = {self.id})'


employeeObject = Employee('employeeName', 20, 1101)

print(employeeObject)
print(employeeObject.__str__())
print(str(employeeObject))
print(employeeObject.__repr__())
print(repr(employeeObject))

# get namespace of an object (all variables in it)
print(employeeObject.__dict__)

# get file location
import ac_basics_modules_example
print(ac_basics_modules_example.__file__)
