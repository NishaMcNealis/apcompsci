"""
This prints out all the vocab combinations when the arguments are given as strings in ARGV. Multiple word
vocab words must be encased in double quotes.
"""

import itertools, sys
words = sys.argv[1:]
combos = list(itertools.combinations(words, 2))
for pair in combos:
    print "%s, %s"%(pair[0], pair[1])
