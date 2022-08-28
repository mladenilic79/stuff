
# json can have only one top level object.. usually dictionary or list

import json

# exapmle data

person = {"name":  "John", "age":  30, "city":  "New York", "hasChildren":  False, "titles": ["engineer", "programmer"]}

# json string

# converting to json string
personJSON = json.dumps(person)
# better with indent and sort_keys
personJSON = json.dumps(person, indent=4, sort_keys=True)
# getting object back from json string
person = json.loads(personJSON)

# json file

# outputing to file
with open('tb_json.json', 'w') as file:
    # json.dump(person, file)
    # better with indent and sort_keys
    json.dump(person, file, indent=4, sort_keys=True)
# getting object back from file
with open('tb_json.json', 'r') as file:
    person = json.load(file)

# exapmle custom data

class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age
user = User('Max', 27)

# json string

# converting to json string: first way: function for serialization
def encode_user(o):
    if isinstance(o, User):
        return {'name': o.name, 'age': o.age, o.__class__.__name__: True}
    else:
        raise TypeError('Object of type User is not JSON serializable')
userJSON = json.dumps(user, default=encode_user)

# converting to json string: second way: class for serialization
from json import JSONEncoder
class UserEncoder(JSONEncoder):
    def default(self, o):
        if isinstance(o, User):
            return {'name': o.name, 'age': o.age, o.__class__.__name__: True}
        return JSONEncoder.default(self, o)
userJSON = json.dumps(user, cls=UserEncoder)
# or
userJSON = UserEncoder().encode(user)

# getting custom object back from json string
def decode_user(dct):
    if User.__name__ in dct:
        return User(name=dct['name'], age=dct['age'])
    return dct
user = json.loads(userJSON, object_hook=decode_user)
