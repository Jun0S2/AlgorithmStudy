# https://school.programmers.co.kr/learn/courses/30/lessons/70128?language=python3
def solution(a, b):
    answer = 0
    for x in range (len(a)) :
        answer += a[x] * b[x]
    return answer