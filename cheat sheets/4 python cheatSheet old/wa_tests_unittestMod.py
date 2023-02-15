
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TESTS BASICS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# assertions

assert (5 == 4), "this is not true statement"


# basic unit tests


def add(a, b):
    return a + b


if __name__ == "__main__":
    if add(1, 2) == 3:
        print("Test for the fib function was successful!")
    else:
        print("The fib function is returning wrong values!")

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ TESTS UNITTEST MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# Method                                              Meaning
# setUp() 	                                          Hook method for setting up the test fixture before exercising it.
#                                                     This method is called before calling the implemented test methods.
# tearDown() 	                                      Hook method for deconstructing the class fixture after running
#                                                     all tests in the class.
# assertEqual(self, first, second, msg=None) 	      The test fails if the two objects are not equal as
#                                                     determined by the '==' operator.
# assertAlmostEqual(self, first, second, places=None, msg=None, delta=None)
#                                                     The test fails if the two objects are unequal as determined by
#                                                     their difference rounded to the given number of decimal places
#                                                     (default 7) and comparing to zero, or by comparing that between
#                                                     the two objects is more than the given delta.
#                                                     Note that decimal places (from zero) are usually not the same as
#                                                     significant digits (measured from the most significant digit).
#                                                     If the two objects compare equal then they will automatically
#                                                     compare almost equal.
# assertCountEqual(self, first, second, msg=None) 	  An unordered sequence comparison asserting that the same elements,
#                                                     regardless of order. If the same element occurs more than once, it
#                                                     verifies that the elements occur the same number of times.
#                                                     self.assertEqual(Counter(list(first)), Counter(list(second)))
# assertDictEqual(self, d1, d2, msg=None) 	          Both arguments are taken as dictionaries and they are checked if
#                                                     they are equal.
# assertTrue(self, expr, msg=None) 	                  Checks if the expression "expr" is True.
# assertGreater(self, a, b, msg=None) 	              Checks, if a > b is True.
# assertGreaterEqual(self, a, b, msg=None) 	          Checks if a ≥ b
# assertFalse(self, expr, msg=None) 	              Checks if expression "expr" is False.
# assertLess(self, a, b, msg=None) 	                  Checks if a < b
# assertLessEqual(self, a, b, msg=None) 	          Checks if a ≤ b
# assertIn(self, member, container, msg=None) 	      Checks if a in b
# assertIs(self, expr1, expr2, msg=None) 	          Checks if "a is b"
# assertIsInstance(self, obj, cls, msg=None) 	      Checks if isinstance(obj, cls).
# assertIsNone(self, obj, msg=None) 	              Checks if "obj is None"
# assertIsNot(self, expr1, expr2, msg=None) 	      Checks if "a is not b"
# assertIsNotNone(self, obj, msg=None) 	              Checks if obj is not equal to None
# assertListEqual(self, list1, list2, msg=None) 	  Lists are checked for equality.
# assertMultiLineEqual(self, first, second, msg=None) Assert that two multi-line strings are equal.q
# assertNotRegexpMatches(self, text, unexpected_regexp, msg=None)
#                                                     Fails, if the text Text "text" of the regular expression
#                                                     unexpected_regexp matches.
# assertTupleEqual(self, tuple1, tuple2, msg=None) 	  Analogous to assertListEqual

import unittest
import ba_modules


class RandomTest(unittest.TestCase):

    def setUp(self):
        self.random_element = 5
        print("setUp executed!")

    def testCalculation(self):
        self.assertEqual(ba_modules.add(1, 2), 3)
        print("test executed!")

    def tearDown(self):
        self.random_element = 6
        print("tearDown executed!")


if __name__ == "__main__":
    unittest.main()
