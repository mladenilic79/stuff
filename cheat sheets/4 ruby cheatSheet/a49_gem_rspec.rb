
# if starting from console could disable tests with -e
# > ruby person.rb -e bacon

# if starting from console -f flag changes passing tests into dots, & F for a failed test, E for an error

# if starting from console --profile flag returns how long it takes to go through each test

require 'rspec/autorun'

class Factorial
  def factorial_of(n)
    (1..n).inject(:*)
  end
end

# group different scenarios in different blocks - optional
context "first" do

  # version 1
  # describe groups test together & points to what class are we testing
  describe Factorial do
  # or with string insted of class
  # describe "Factorial" do

    # execute code before/after tests, not sure what this do
    # before(:all) { Factorial.prepare_database }
    # after (:all) { Factorial.cleanup_database }

    # concrete test
    # disable test with x before it like this xit
    it "finds the factorial of 5" do
      calculator = Factorial.new
      solution = calculator.factorial_of(5)
      # use only one expect per test
      # test for equality
      expect(solution).to eq(120)
      # not_to as opposed to to
      expect(3).not_to be 4
      # test for the same object
      expect(6).to be 6
      expect(nil).to be nil
      expect([1,2,3]).to include(1) # for arrays & hashes
      expect([1,2,3]).to start_with(1)
      expect([1,2,3]).to end_with(3)
      expect([]).to be_empty
      expect(2).to be_between(1,3)
      expect(3).to be >= 2
      expect(3).to be < 5
      expect(2).to be_between(1,3).inclusive
      expect(2).to be_between(1,3).exclusive
      expect(true).to be true
      expect(false).to be false
      expect(5).to be_truthy # evaluette to not false or nil
      expect(nil).to be_falsey # evaluette to false or nil
      # match (for regular expression matching)
      expect("test").to match /TEST/i
      expect { 1/0 }.to raise_error(ZeroDivisionError)
      expect { 1/0 }.to raise_error("divided by 0")
      expect { 1/0 }.to raise_error("divided by 0", ZeroDivisionError)
      expect({"tom"=>"england",
                    "sim"=>56887,
                    "lik"=>"3345"}).to have_key("tom")
      expect({"tom"=>"england",
                    "sim"=>56887,
                    "lik"=>"3345"}).to have_value("england")
      expect({}).to be_empty
      # for instance of
      expect(calculator).to be_instance_of(Factorial)
      # for instance of or any parent of
      expect(calculator).to be_kind_of(Factorial)
      expect("duzina").to respond_to(:length)
      # have_attributes (for testing instance variables)
      # raise_error & change matcher needs to be in block
      expect{ 6.count }.to raise_error(NoMethodError)
    end
  end
end

  # version 2
  describe Factorial do
    # use let for lazy creating of Factorial class, so to not need to recreate over & over again in all the tests
    let(:name_of_new_class) { Factorial.new }
    # use not lazy let for creating needed object ahead of time
    let!(:name_of_new_class) { Factorial.new }
    it "finds the factorial of 5" do
      solution = name_of_new_class.factorial_of(5)
      expect(solution).to eq(120)
    end
  end
