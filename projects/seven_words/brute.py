import itertools, sys

f = open('/usr/share/dict/words').read().split('\n')

def is_word(string):
    return string in f

def find_words(blocks, num):
    words = []
    for i in itertools.permutations(blocks, num):
        if is_word("".join(i)):
            words.append("".join(i))
    return words

blocks = sys.argv[1:-1]
num = int(sys.argv[-1])

for i in find_words(blocks, num):
    print i
