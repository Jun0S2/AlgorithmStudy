
# https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=python3
from itertools import * # permutations, combinations 
def solution(numbers):
    answer = []
    # 두개 뽑기
    combi = list(combinations(numbers, 2))
    for x in combi :
        element = x[0] + x[1]
        if element not in answer :
            answer.append(element)
    
    return sorted(answer)