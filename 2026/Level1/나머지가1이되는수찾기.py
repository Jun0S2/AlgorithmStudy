# https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=python3
def solution(n):
    answer = 0
    # Brute force
    for x in range(1,n) :
        if(n%x==1) :
            return x
    return answer