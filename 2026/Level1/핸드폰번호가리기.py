# https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=python3
def solution(phone_number):
    s = list(phone_number)
    for x in range(len(phone_number)-4):
        s[x] = '*'
        
    return "".join(s)