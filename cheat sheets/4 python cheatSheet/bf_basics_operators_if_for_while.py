
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OPERATORS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Conditional operators
# > : Greater than
# < : Less than
# >= : Greater than or equal to
# <= : Less than or equal to
# == : Equal to
# != : Not equal to

# Logical operators
# and : If both are true it returns true
# or : If either are true it returns true
# not : Converts true into false and vice versa

# bitwise operators (and shift operators)
# & : and
# | : or
# ^ : xor
# ~
# <<
# >>

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ IF TERNARY @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ---------- if else ----------

a = 4

if (a >= 9) and (7 <= 18):
    print("Important Birthday")
elif (5 == 5) or (a != 50):
    print("Important Birthday")
elif not a < 65:
    print("Important Birthday")
else:
    print("Sorry Not Important")

# ---------- ternary ----------

is_nice = True
state = "nice" if is_nice else "not nice"

# ---------- any/all ----------

# returns true if any/all element is/are true
mylist = [False, True, False]
a = all(mylist)
a = any(mylist)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LOOPS FOR FOR EACH @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

listt = [1, 2, 3, 4]

# ---------- for each ----------

for i in listt:
    val = i
else:
    pass

for char in "pero":
    val = char

# ---------- for classic ----------

# We can also have range define our list for us. range(10) will create a list
# starting at 0 and go up to but not include the value passed to it.
for i in range(4):
    val = i

# define with len()
for i in range(len(listt)):
    val = listt[i]

# with starting and ending value
for i in range(2, 6):
    val = i

# with added step
for i in range(0, len(listt) - 1, 2):
    val1 = i
    val2 = listt[i]

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LOOPS WHILE DO WHILE BREAK CONTINUE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# ---------- BASICS ----------
# The value we increment in the while loop is defined before the loop
i = 1
# Define the condition that while true we will continue looping
while i < 5:
    # You must increment your iterator inside the while loop
    i += 1
    val = i

# ---------- BREAK AND CONTINUE ----------
i = 1
while i < 10:
    if (i % 2) == 1:
        i += 1
        continue
    if i == 8:
        break
    i += 1
    val = i
else:
    print('if the loop is left by break, else statement will not be executed')

# ---------- DO WHILE LOOP - IMPLEMENTATION ----------
# By giving the while a value of True it will cycle until a break is reached
i = 1
while True:
    if i == 5:
        break
    i += 1
    val = i
