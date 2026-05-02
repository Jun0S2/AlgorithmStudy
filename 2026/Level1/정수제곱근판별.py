# https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=python3
import math

def solution(n):
    answer = 0
    res = math.sqrt(n)
    if (int(res)**2 == n ) : 
        answer = (res+1)**2
    else :
        answer = -1
    
    return answer