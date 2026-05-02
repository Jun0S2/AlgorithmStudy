2026.05.02 목표 : level 1 복습 및 파이썬 학습

https://school.programmers.co.kr/learn/courses/30/lessons/12925?language=python3
-python 에서는 +,- 있어도 복잡한 연산 없이 그냥 int(string_variable) 하면 자동변환됌.

https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=python3#
for loop
for **_ in _** : or for \_\_\_ in range () :

https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=python3

https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=python3
stack 없이
def solution(n):
return [int(x) for x in str(n)][::-1]
이렇게도 가능하다고함;;;

https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=python3
def solution(n):
digits = list(str(n)) # 한글자씩 리스트로 만듦
digits.sort(reverse=True) # 리스트 sort
return int(''.join(digits)) # ''.join(digits) -> Int type
문화충격..

math library : import math

https://school.programmers.co.kr/learn/courses/30/lessons/12937?language=python3

https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=python3
