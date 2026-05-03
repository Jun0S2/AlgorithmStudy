# https://school.programmers.co.kr/learn/courses/30/lessons/12922?language=python3
def solution(n):
    answer =  ""
    for x in range(n) :
        answer += "수" if x%2==0 else "박"
    return answer