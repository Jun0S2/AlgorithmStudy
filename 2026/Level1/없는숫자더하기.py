# https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=python3
def solution(numbers):
    answer = 0
    exists = [False] * 10
    for x in numbers :
        exists[x] = True
    
    # print(exists)
    for x in range(1,10):
        if exists[x] == False:
            answer += x
    return answer