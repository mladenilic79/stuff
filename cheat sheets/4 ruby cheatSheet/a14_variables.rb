
# ruby is dinamicly typed,
# varibales can be reassigned to objects of different types

# variable names should be with lower case - lower snake case
lower_snake_case = "pera simovic"

# paralele variable assignments - shorthand
a, b, c = 10, 20, 30
p a, b, c

# switching variables
# this works because right side of every declaration is evalueted first
a, b = b, a
p a, b

# constants are marked with upper case
PI = 3.14
# PI = 3 # this returns error, already assigned

a.freeze # freeze prevents modification to the variable
p a.frozen? # returns if frozen

# conditional assignments
y = nil
p y
# conditional operator, assign only if original value is nil
y ||= 5
p y
# prohibited operation, will not change value
y ||= 10
p y

# double colon meaning
module SomeModule
    module InnerModule
        class MyClass
            CONSTANT = 4
        end
    end
end
# You could access CONSTANT from outside the module as
SomeModule::InnerModule::MyClass::CONSTANT.
