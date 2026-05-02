# https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=python3
def solution(s):
    middle = int(len(s)/ 2) -1
    # even else odd
    answer = s[middle:middle+2] if len(s)%2==0 else s[middle+1] 
    return answer