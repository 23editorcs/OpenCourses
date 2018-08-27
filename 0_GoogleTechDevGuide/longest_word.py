#!/usr/bin/env python3
'''
Fing longest word in dictionary that is a subsequence of a given string
'''
import collections
import sys

import subdict as subdict


def longest_word(letters, words):
    '''
    s is a given string which word is should be subsequence of s
    d is a dictionary which could be any format (list, hash table, prefix tree...
        '''
    letter_positions = collections.defaultdict(list)
    # For each letter in 'letters', collect all the indices at which it appears
    # O(#letters) space and speed
    for index, letter in enumerate(letters):
        letter_positions[letter].append(index)
    #For words, in descending order by length...
    # Bails out early on first match word
    for word in sorted(words, key=lambda w: len(w), reverse=True):
        pos = 0
        for letter in word:
            if letter not in letter_positions:
                break

            possible_positions = [p for p in letter_positions[letter] if p >= pos]
            print(possible_positions)
            if not possible_positions:
                break
            pos = possible_positions[0] + 1
        else:
            return word
'''
if __name__ == '__main__':
    print(longest_word("abppplee", {"able", "ale", "apple", "bale", "kangaroo"}))
'''
print(longest_word("abppplee", {"able", "ale", "apple", "bale", "kangaroo"}))

            




            
                


