# https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=python3
def solution(arr):
    # Base Case
    if len(arr) == 0 :
        return arr
    
    prev = arr[0]
    answer = [prev]
    for x in arr :
        if prev != x  :
            answer.append(x)
        prev = x
    
    return answer