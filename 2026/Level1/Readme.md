# Programmers Level 1 Study Log (Python)

**Date:** 2026.05.02 ~ 2026.05.03
**Goal:** Level 1 문제 복습 + Python 기본 문법 및 활용 패턴 정리

---

## Day 1 (2026.05.02)

### 1. 문자열 → 정수 변환

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12925

```python
int("1234")
int("-1234")
```

- Python은 +, - 포함 문자열도 자동 변환 가능
- 별도 파싱 없이 `int()` 사용

---

### 2. 약수의 합

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12928

```python
for i in range(n):
    pass
```

- 기본 반복문 패턴

---

### 3. 자연수 뒤집어 배열로 만들기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12932

```python
def solution(n):
    return [int(x) for x in str(n)][::-1]
```

- string → list → reverse

---

### 4. 정수 내림차순으로 배치하기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12933

```python
def solution(n):
    digits = list(str(n))
    digits.sort(reverse=True)
    return int(''.join(digits))
```

---

### 5. math 라이브러리

```python
import math
```

---

### 6. 서울에서 김서방 찾기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12919

```python
def solution(seoul):
    return f"김서방은 {seoul.index('Kim')}에 있다"
```

---

### 7. 핸드폰 번호 가리기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12948

```python
def solution(phone_number):
    return phone_number[-4:].rjust(len(phone_number), "*")
```

---

## Day 2 (2026.05.03)

### 1. 수박수박수박수박수박수?

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12922

---

### 2. 제일 작은 수 제거하기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12935

```python
min(arr)
```

---

### 3. 내적

문제: https://school.programmers.co.kr/learn/courses/30/lessons/70128

```python
def solution(a, b):
    return sum(x * y for x, y in zip(a, b))
```

---

### 4. 약수의 개수와 덧셈

문제: https://school.programmers.co.kr/learn/courses/30/lessons/77884

```python
import math

def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        if int(math.sqrt(i)) ** 2 == i:
            answer -= i
        else:
            answer += i
    return answer
```

---

### 5. 문자열 내림차순으로 배치하기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12917

```python
def solution(s):
    return ''.join(sorted(s, reverse=True))
```

---

### 6. 부족한 금액 계산하기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/82612

```python
def solution(price, money, count):
    total = price * (count * (count + 1) // 2)
    return max(0, total - money)
```

---

### 7. 문자열 다루기 기본

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12918

```python
s.isdigit()
```

---

### 8. 행렬의 덧셈

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12950

```python
def solution(arr1, arr2):
    return [[x + y for x, y in zip(a, b)] for a, b in zip(arr1, arr2)]
```

---

### 9. 직사각형 별찍기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12969

---

### 10. 같은 숫자는 싫어

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12906

---

### 11. 최대공약수와 최소공배수

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12940

```python
import math

def solution(n, m):
    return [math.gcd(n, m), (n * m) // math.gcd(n, m)]
```

---

### 12. 크기가 작은 부분 문자열

문제: https://school.programmers.co.kr/learn/courses/30/lessons/147355

```python
substrings = [t[i:i+k] for i in range(len(t) - k + 1)]
```

---

### 13. 두 개 뽑아서 더하기

문제: https://school.programmers.co.kr/learn/courses/30/lessons/68644

```python
from itertools import combinations

def solution(numbers):
    return sorted(set(sum(c) for c in combinations(numbers, 2)))
```

---

### 14. 시저 암호

문제: https://school.programmers.co.kr/learn/courses/30/lessons/12926

```python
ord()
chr()
```

---

### 15. 가장 가까운 같은 글자

문제: https://school.programmers.co.kr/learn/courses/30/lessons/142086

```python
def solution(s):
    result = []
    last = {}

    for i, char in enumerate(s):
        if char in last:
            result.append(i - last[char])
        else:
            result.append(-1)
        last[char] = i

    return result
```

---

## 핵심 패턴 정리

```python
sum(x*y for x,y in zip(a,b))
sorted(s, reverse=True)
set(arr)
combinations(numbers, 2)
s.isdigit()
math.gcd(n, m)
s[:idx+1][::-1]
t[i:i+k]
```

https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=python3
sort 문제. 콤비네이션으로 접근햇다가 시간초과

https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=python3

https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=python3

https://school.programmers.co.kr/learn/courses/30/lessons/134240
https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/132267

https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=python3
c++에서는compare override했엇는데..
def solution(strings, n):
return sorted(strings, key=lambda x: (x[n], x))
이렇게하면.. sorted(글자, key = )
key=lambda x: (x[n], x)
x[n] => n번째 글자로 먼저 정렬
x => 만약 같으면 전체 문자열로 사전순 정렬

https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=python3
reduced = set()
set(existingarr)
-> 중복제거

https://school.programmers.co.kr/learn/courses/30/lessons/176963
dictionary
dic = dict(zip(name, yearning))

https://school.programmers.co.kr/learn/courses/30/lessons/138477
billboard.pop(0)
array의 첫번째 요소 없애기.

https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=python3
bin(number) : to binary
anded = bin(arr1[x] | arr2[x])[2:] # 0b 제거
anded = anded.rjust(n, '0') # 문자열 길이를 n으로 맞추되 왼쪽에 0 추가

https://school.programmers.co.kr/learn/courses/30/lessons/159994
