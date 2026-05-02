# https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=python3#
def solution(n):
    if n == 0 or n == 1:
        return n
    
    answer = 1 + n
    for x in range(2, n):
        if n % x == 0:
            answer += x
    return answer