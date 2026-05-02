# https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=python3
def solution(x):    
    digits = []
    for y in str(x):
        digits.append(int(y))

    return True if x%sum(digits)==0 else False