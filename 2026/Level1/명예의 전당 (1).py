# https://school.programmers.co.kr/learn/courses/30/lessons/138477
def solution(k, score):
    answer = []
    billboard = []
    for x in score:
        billboard.append(x)
        billboard.sort()
        
        if (len(billboard) >k ):
            billboard.pop(0)
        
        answer.append(min(billboard))
    return answer