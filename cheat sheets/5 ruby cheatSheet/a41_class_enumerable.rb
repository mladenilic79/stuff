
class ConvenienceStore
  include Enumerable

  attr_reader :snacks

  def initialize
    @snacks = []
  end

  def add_snack(snack)
    snacks << snack
  end

  # overrided method for access to collection
  def each
    snacks.each do |snack|
      # pass element to outside of method
      yield snack
    end
  end
end

bodega = ConvenienceStore.new
bodega.add_snack("slim")
bodega.add_snack("doritos")
bodega.add_snack("ranchers")

# standard access
bodega.each { |snack| puts "#{snack} is delicios"}

p bodega.any? { |snack| snack.length > 10 }
p bodega.all? { |snack| snack.length > 10 }
p bodega.map { |snack| snack.upcase }
p bodega.select { |snack| snack.downcase.include?("i") }
p bodega.reject { |snack| snack.upcase.include?("I")}
p bodega.sort
p bodega.first

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# example 2 :

class Menu
  include Enumerable

  # overrided each method to access to collection
  def each
    yield "pizza"
    yield "spaghetti"
    yield "salad"
    yield "water"
    yield "bread"
  end
end

menu_options = Menu.new

# standard access
menu_options.each do |item|
  puts "would you like : #{item}"
end

p menu_options.find{|item| item = "pizza"}
p menu_options.select{|item| item.size <=5}
p menu_options.reject{|item| item.size <=5}
p menu_options.first
p menu_options.take(2)
p menu_options.drop(2)
p menu_options.min
p menu_options.max
p menu_options.sort
menu_options.reverse_each{|item| puts item}
