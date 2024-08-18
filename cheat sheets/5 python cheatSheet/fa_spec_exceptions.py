
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TRY CATCH @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

try:
    number = int(input("Please enter a number : "))
except ValueError:
    print("first line")
    print(ValueError)
    print(ValueError.args)
except (ValueError, IndexError, NameError) as ex:
    print("second line")
    print(ex)
    print(ex.args)
except:
    print("If the exception wasn't caught above this will catch all others")
else:
    print("else is only executed if no exception was raised")
finally:
    print("I execute no matter what")


# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RAISING THROWING @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

x = 4
if x > 5:
    raise NameError('this is an exception')
# or
    raise Exception('HiThere')


# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ EXCEPTIONS CUSTOM @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Create a class that inherits from Exception
class ValueTooHighError(Exception):
    pass

# raising
if x > -100:
    raise ValueTooHighError("and value is too high")
