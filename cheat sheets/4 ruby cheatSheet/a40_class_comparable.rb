
class OlympicMedal

  include Comparable

  # custom values to use for comparing
  MEDAL_VALUES = {"Gold" => 3, "Silver" => 2, "Bronze" => 1}

  attr_reader :type

  def initialize(type)
    @type = type
  end

  def <=>(other)
    if MEDAL_VALUES[type] < MEDAL_VALUES[other.type]
      -1
    elsif MEDAL_VALUES[type] == MEDAL_VALUES[other.type]
      0
    else
      1
    end
  end
end

bronze = OlympicMedal.new("Bronze")
silver = OlympicMedal.new("Silver")
gold = OlympicMedal.new("Gold" )

puts bronze > silver
puts gold <= bronze
puts silver.between?(bronze, gold)
