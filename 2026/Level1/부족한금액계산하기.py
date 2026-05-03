# https://school.programmers.co.kr/learn/courses/30/lessons/82612?language=python3
# y = price * count
def ride(p,c):
    return p*c

def solution(price, money, count):
    answer = money
    for x in range(1,count+1) :
        answer -= ride(price, x)
    return answer*-1 if answer <=0 else 0