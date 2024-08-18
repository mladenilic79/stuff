
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ RANDOM MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

import random

# random elements from random module are reproducible with seed command
# random.seed(1)

# some data
listt = ["a", "b", "c", "d", "e", "f", "g"]

# Generate a random integer between 1 and 49
rand_value = random.randrange(1, 50)

# Generate a random integer between 1 and 50
rand_value = random.randint(1, 50)

# generate a random float between 1 and 50
rand_value = random.uniform(1, 50)

# generate a random float between 0 and 1
rand_value = random.random()

# pick value from list
rand_value = random.choice(listt)

# pick multiple unique values from a list
rand_value = random.sample(listt, k=3)

# pick multiple non unique values from a list
rand_value = random.choices(listt, k=3)

# shuffle elements in place
rand_value = random.shuffle(listt)

# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ SECRETS MODULE @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# recommended for security purposes
import secrets

# some data
listt = ["a", "b", "c", "d", "e", "f", "g"]

# pick random from 0 to 10 (10 not included)
a = secrets.randbelow(10)

# pick random from 0 to 4 bits (1111 - 15)
a = secrets.randbits(4)

# pick random choice from list
a = secrets.choice(listt)
