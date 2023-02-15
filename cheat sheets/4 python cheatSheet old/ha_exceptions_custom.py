
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ EXCEPTIONS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# try catch block

try:
    number = int(input("Please enter a number : "))
except ValueError:
    print("first line")
    print(ValueError)
    print(ValueError.args)
except (ValueError, IndexError, NameError):
    print("second line")
except ValueError as ex:
    print("third line")
    print(ex)
    print(ex.args)
# If the exception wasn't caught above this will catch all others
except:
    print("forth line")
    # raise in except block will re-raise last exception
    # raise
# else is only executed if no exception was raised
else:
    print("You didn't raise an exception")
finally:
    print("I execute no matter what")

# raising / throwing exceptions

x = 4
if x > 5:
    raise Exception
# or
    raise NameError('HiThere')

print()
print()
print()

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ EXCEPTIONS CUSTOM @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Create a class that inherits from Exception
class ValueTooHighError(Exception):
    pass

# raising
if x > -100:
    raise ValueTooHighError("and value is too high")
