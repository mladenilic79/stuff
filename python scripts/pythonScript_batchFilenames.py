
import os
import re
import eyed3
import mutagen
from mutagen.mp3 import MP3

directory_path = 'e:/MUSIC ORIGINAL/'

# editing name
# for oldname in os.listdir(directory_path):
#     print(oldname)
#     regex = re.compile(r'[ ]+.mp3$')
#     newname = regex.sub('.mp3', oldname)
#     print(newname)
#     oldfile = os.path.join(directory_path, oldname)
#     print(oldfile)
#     newfile = os.path.join(directory_path, newname)
#     print(newfile)
#     os.rename(oldfile, newfile)

# editing attributes
counter = 0
for name in os.listdir(directory_path):
    counter += 1
    print(counter)

    # this doesn't work for eye3d
    # if (counter == 88 or counter == 154 or counter == 575 or counter == 610 or counter == 612):
    #     continue

    full_path = directory_path + name
    print(name)

    regex_pattern_object = re.compile(r"(^.+) - (.+).mp3")
    match_object = re.search(regex_pattern_object, name)

    artist_name = match_object.group(1)
    print(artist_name)
    title_name = match_object.group(2)
    print(title_name)

    # eye3d library variant
    # audiofile = eyed3.load(full_path)
    # audiofile.tag.artist = artist_name
    # audiofile.tag.albumartist = artist_name
    # audiofile.tag.album_artist = artist_name
    # audiofile.tag.Album_artist = artist_name
    # audiofile.tag.title = title_name
    # audiofile.tag.save()

    # mutagen library variant
    # mutagen_object = mutagen.File(full_path)
    # mutagen_object = MP3(full_path)
    # print(mutagen_object.info.length)
    # print(mutagen_object.info.bitrate)
    # print(mutagen_object.info.pprint())
    # print(mutagen_object["Title"])

    print()
