# https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=python3
def ones(x):
    return bin(x).count('1')

def solution(n):
    answer = 0
    n_cnt = ones(n)
    curr_num = n+1
    
    while (True) :
        if n_cnt == ones(curr_num) : 
            return curr_num
        curr_num +=1
    
    return answer