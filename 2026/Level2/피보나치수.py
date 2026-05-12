# https://school.programmers.co.kr/learn/courses/30/lessons/12945?language=python3
def solution(n):
    answer = 0
    # base case : F(0), F(1)
    fibo = [0,1]
    
    # (a + b) % M = ((a % M) + (b % M)) % M
    for x in range(2,n+1):
        fibo.append((fibo[x-2]+fibo[x-1])%1234567)
  
    return fibo[n]