
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# @@@@@@@@@@ OOP JSON @@@@@@@@@@
# @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

# json can have only one top level object.. usually dictionary or list

import json
from pathlib import Path

# exapmle data
person = {"name":  "John", "age":  30, "city":  "New York", "hasChildren":  False, "titles": ["engineer", "programmer"]}

# ---------- json string ----------

# converting to json string
personJSON = json.dumps(person)
# better with indent and sort_keys
personJSON = json.dumps(person, indent=4, sort_keys=True)
# getting object back from json string
person = json.loads(personJSON)

# ---------- set dirs & files ----------

working_directory_path = Path(r"C:\Users\mlade\Documents")
working_directory_file = working_directory_path / Path('test.json')

# ---------- json file default ----------

# outputing to file
with open(working_directory_file, 'w') as file:
    # dumping json string
    # json.dump(person, file)
    # better with indent and sort_keys
    json.dump(person, file, indent=4, sort_keys=True)

# getting object back from file
with open(working_directory_file, 'r') as file:
    person = json.load(file)

# delete file
working_directory_file.unlink(missing_ok=False)

# ---------- json file with pathlib ----------

with working_directory_file.open(mode="w") as file:
    # dumping json string (dump only one json object else error)
    # json.dump(person, file)
    # better with indent and sort_keys
    json.dump(person, file, indent=4, sort_keys=True)

with working_directory_file.open(mode='r') as file:
    person = json.load(file)

# delete file
working_directory_file.unlink(missing_ok=False)

# ---------- json with classes ----------
# ---------- refer to somewhere else ----------
