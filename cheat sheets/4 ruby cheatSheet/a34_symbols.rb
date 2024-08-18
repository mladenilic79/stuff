
puts :name # declaration of symbol
p :name # declaration of symbol

p :name.methods # all available methods to symbol
p :name.class
p :name.to_s # convert symbol to string
p "age".to_sym # convert string to symbol
p "school bus".to_sym # add "" becouse of space
