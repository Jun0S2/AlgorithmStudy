# https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=python3
def solution(s):
    answer = True
    pair = 0
    
    for x in s :
        if x == "(" :
            pair += 1
        else :
            pair -=1
        
        if (pair<0):
            return False
        
    
    return True if pair == 0 else False