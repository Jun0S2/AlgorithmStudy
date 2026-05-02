# https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=python3
def solution(num):
    answer = 0
    cnt = 0
    while cnt < 500:
        # 2
        if num == 1 :
            return answer
        # 1-1
        if num%2==0:
            num = num /2 
        # 1-2
        else :
            num = num * 3 + 1
        answer +=1
        cnt +=1
    return -1