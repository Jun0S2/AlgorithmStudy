# https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=python3
def solution(arr, divisor):
    answer = []
    for x in arr:
        if x % divisor == 0:
            answer.append(x)
    if len(answer) == 0  : 
        answer.append(-1)
    answer.sort()
    return answer