# https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=python3

from itertools import *
def is_prime(num):
    if num == 0 or num == 1 :
        return False
    for x in range (2,num):
        if num % x == 0 :
            return False;
    return True;

def solution(numbers):
    answer = 0
    # set : without duplication
    vec = set() # this is how to declere set
    
    for times in range(len(numbers)):
        for x in permutations(numbers, times+1):
            # vec.set(''.join)
            if x[0] == '0':
                continue
            temp = ''.join(x)
            # print(temp)
            vec.add(temp) if is_prime(int(temp)) else None
    # print(vec)
    return len(vec)