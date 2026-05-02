# https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=python3
def swap(a,b):
    return (b,a)

def solution(a, b):
    answer = 0
    if a == b:
        return a
    if b<a :
        a,b = swap(a,b)
    
    for x in range(a,b+1):
        answer += x
    return answer