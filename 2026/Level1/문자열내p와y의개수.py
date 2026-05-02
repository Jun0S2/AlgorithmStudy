# https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=python3#
def solution(s):
    if not 'p' in s and 'y' not in s :
        return True
    
    p_count = 0
    y_count = 0
    
    for x in s:
        if x == 'p' or x == 'P':
            p_count +=1
        if x == 'y'or x == 'Y':
            y_count +=1
    
    return True if p_count == y_count else False