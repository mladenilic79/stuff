
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ LOOPING NESTED DICTIONARY @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

dict1 = dict(one=1, two=2)
dict2 = dict(three=3, four=4)
dict3 = dict(five=5, six=6)
dict4 = dict(internal_dict1=dict1, internal_dict2=dict2, internal_dict3=dict3)

# looping nested dictionary
for key4 in dict4:
    a = key4
    a = dict4[key4]
    internal_dict = dict4[key4]
    for key in internal_dict:
    # same as
    # for key in dict4[key4]
        b = key
        b = internal_dict[key]
        # same as
        # b = dict4[key4][key]
