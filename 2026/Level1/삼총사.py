# https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=python3
from itertools import *

def solution(number):
    answer = 0
    comb = list(combinations(number,3))
    for x in comb:
        if sum(x) == 0 :
            answer+=1
    return answer