# https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=python3
def isEven_factors(number) :
    factors = []
    for x in range(1, number+1):
        if number % x == 0 :
            factors.append(x)
    return True if len(factors) %2 == 0 else False
    # return factors

def solution(left, right):
    answer = 0
    for x in range(left, right+1) : 
        if isEven_factors(x)  :
            answer += x
        else :
            answer -= x
    return answer