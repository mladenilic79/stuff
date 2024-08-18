
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP SLOTS @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# slots limits attributes to only specified ones

class SlotsExample(object):

    __slots__ = ['val_1', 'val_2']

    def __init__(self, val_1, val_2):
        self.val_1 = val_1
        self.val_2 = val_2


slotExample = SlotsExample(4, 5)

print(slotExample.val_1)
print(slotExample.val_2)

# declaring new attributes returns error
slotExample.a = 4
