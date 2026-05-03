# https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=python3
def gcd(a, b):
    # b가 0이 될 때까지 반복
    while b:
        # a에는 b를 넣고,
        # b에는 a를 b로 나눈 나머지를 넣는다
        a, b = b, a % b
        
    # b가 0이 되면, 그때의 a가 최대공약수
    return a


def solution(n, m):
    # 1. 최대공약수 구하기
    g = gcd(n, m)
    
    # 2. 최소공배수 공식: (n * m) // gcd
    l = (n * m) // g
    
    # 3. [최대공약수, 최소공배수] 반환
    return [g, l]