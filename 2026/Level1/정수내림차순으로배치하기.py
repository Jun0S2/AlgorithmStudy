# https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=python3
def solution(n):
    digits = list(str(n)) # 한글자씩 리스트로 만듦
    digits.sort(reverse=True) # 리스트 sort
    return int(''.join(digits)) # ''.join(digits) -> Int type