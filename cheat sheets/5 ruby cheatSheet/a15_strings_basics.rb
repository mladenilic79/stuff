
# declaration
p osoba = "perovic" # prefered way
p osoba2 = 'jovanovic'
  # line breaks & interpolation doesn't work for single
p osoba3 = String.new("simic")
p broj = 3

# multiline strings
puts multiline_string = <<MLS
  this is multiline String
    tabs will also be preserved
MLS

# double quotes
p string1 = "zdravo 'da' li si dobro"
p string2 = 'zdravo "da" li si dobro'

# escape characters
p string3 = "hello \"dear\" darling"
p string4 = 'hello \'dear\' darling' # not secure

# special characters
p "here is a\nline break"
p "\tinsert tab to the left"

# string interpolation
p "print #{osoba} print"
p "print #{broj} print"
p "print #{2 + 2} print"
