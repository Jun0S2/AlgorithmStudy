# https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=python3
def solution(n):
    answer = []
    stack = []

    for x in str(n):
        stack.append(int(x))
    
    while stack:
        answer.append(stack.pop())
        
    return answer
