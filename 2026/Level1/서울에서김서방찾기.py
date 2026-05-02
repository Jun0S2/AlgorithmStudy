# https://school.programmers.co.kr/learn/courses/30/lessons/12919?language=python3

def solution(seoul):
    answer = "김서방은 "
    for x in range(len(seoul)):
        if seoul[x] == "Kim":
            answer += str(x)
            answer += "에 있다"
            return answer
    return answer

    