import itertools, sys
words = sys.argv[1:]
combos = list(itertools.combinations(words, 2))
for pair in combos:
    print "%s, %s"%(pair[0], pair[1])
