
# monkey pathing is adding/overriding classes both standard & custom

class Array

  # adding method to standard array class
  def sum
    total = 0
    self.each { |element| total += element if element.is_a?(Numeric) }
    total
  end

end

p [1, "2", 3, false, 5, "hello"].sum
