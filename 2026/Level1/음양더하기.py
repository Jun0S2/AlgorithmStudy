# https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=python3
def solution(absolutes, signs):
    answer = 0
    current = 0
    for x in range(len(absolutes)):
        current = absolutes[x]
        if signs[x] == False:
            current *= -1
        answer += current
    return answer