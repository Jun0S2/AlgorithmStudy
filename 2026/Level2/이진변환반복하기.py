# https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=python3
def solution(s):
    zeros = 0
    cnt = 0

    while(len(s)>1):
        cnt += 1
        zeros += s.count("0")
        s = s.replace("0","") # string은 immutable이라 새로 assign
        # 0 제거 후 길이를 이진수로 변환해야함
        s = bin(len(s))[2:] 

    return [cnt, zeros] #이진 변환 횟수, 제거된 0의 개수