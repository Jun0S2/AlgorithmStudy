# https://school.programmers.co.kr/learn/courses/30/lessons/42748
def solution(array, commands):
    answer = []
    for x in commands:
        k = x[2]
        subarr = array[x[0]-1:x[1]]
        subarr.sort()
        answer.append(subarr[k-1])
        
    return answer