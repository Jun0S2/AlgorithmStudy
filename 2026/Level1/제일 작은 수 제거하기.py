# https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=python3
def solution(arr):
    answer = []
    if len(arr) <= 1 :
        answer.append(-1)
    else :
        minValue = min(arr)
        for x in arr :
            if x != minValue :
                answer.append(x)    
    return answer