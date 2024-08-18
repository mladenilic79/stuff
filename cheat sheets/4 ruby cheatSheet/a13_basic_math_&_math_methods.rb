
# basic operations
p 3 + 4
p 5 - 2
p 3 * 4
p 4 / 5 # round
p 3.0 / 5 # convert to float
p 3 / 5.0 #c onvert to float
p 2 ** 3 # power or exponent
p 5 % 2 # modulo

# methods equivalent of basic operations
p 1.+(2)
p 10.-(5)
p 2.*(3)
p 2.**(3)
p 5./(2) # rounding
p 5.0./(2.0)
p 11.div(2) # save as above, rounding
p 10.%(3)
p 10.modulo(3) # same as above

a = 1
# assignment operators
p a += 9 # a = a + 5
p a -= 8 # a = a - 3
p a *= 4 # a = a * 3
p a /= 2 # a = a / 2
p a **= 2 # a = a ** 2
p a %= 3 # a = a % 3

# basic math methods
p 10.3.floor # rounding to lower & converting to integer
p 10.3.ceil # rounding to higher & converting to integer
p 12.23.round # rounding to closer & converting to integer
p 12.23.round(2) # round to two digits
p -23.33.abs # returns absolute value
p 10.next # gives next element from natural order

# math module (there are various constants & methods)
# constants
puts Math::PI
# methods
puts Math.sqrt(29.8734)
puts Math.sin(90)
