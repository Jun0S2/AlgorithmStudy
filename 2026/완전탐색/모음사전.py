# https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=python3
from itertools import *
# 중복 순열 : product(repeat)
def solution(word):
    letters = ['A', 'E', 'I', 'O', 'U']
    def lookup_table():
        tab = []
        for r in range (1,6):
            for x in product(letters, repeat=r):
                tab.append("".join(x))
                # if("".join(x) == word):
                #     return cnt
    # answer = lookup_table();
        return sorted(tab)
    
    def find_word(lookup):
        for x in range(0,len(lookup)):
            if lookup[x] == word:
                return x
    # print(type(lookup_table()))
    answer = find_word(lookup_table()) +1
    return answer