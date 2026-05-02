https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=python3
def solution(x, n):
    answer = []
    for y in range(1, n+1) :
        answer.append( x * y )
    return answer