# Programmers Level 1 Study Log (Python)

**Date:** 2026.05.02
**Goal:** Level 1 문제 복습 + Python 기본 문법 정리

---

## TIL

### 1. 문자열 → 정수 변환 (자동 처리)

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12925](https://school.programmers.co.kr/learn/courses/30/lessons/12925)

```python
int("1234")
int("-1234")
```

👉 Python은 +, - 포함 문자열도 자동 변환 가능
👉 별도 파싱 없이 int()로 처리 가능

---

### 2. 반복문 기본 패턴

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12928](https://school.programmers.co.kr/learn/courses/30/lessons/12928)

```python
for i in range(n):
    pass

for _ in iterable:
    pass
```

👉 `_` : 값 안 쓰는 경우 관용 표현

---

### 3. 리스트 뒤집기 (stack 없이)

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12932](https://school.programmers.co.kr/learn/courses/30/lessons/12932)

```python
def solution(n):
    return [int(x) for x in str(n)][::-1]
```

👉 핵심: string → list → slicing reverse

---

### 4. 숫자 내림차순 정렬

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12933](https://school.programmers.co.kr/learn/courses/30/lessons/12933)

```python
def solution(n):
    digits = list(str(n))
    digits.sort(reverse=True)
    return int(''.join(digits))
```

👉 sort(reverse=True) + join + int 패턴

---

### 5. math library

```python
import math
```

👉 제곱 / 루트 / 올림 / 내림 등 수학 함수

---

### 6. f-string

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12919](https://school.programmers.co.kr/learn/courses/30/lessons/12919)

```python
def solution(seoul):
    return f"김서방은 {seoul.index('Kim')}에 있다"
```

👉 문자열 안에 변수 바로 삽입 가능

---

### 7. 문자열 슬라이싱 + padding

문제: [https://school.programmers.co.kr/learn/courses/30/lessons/12948](https://school.programmers.co.kr/learn/courses/30/lessons/12948)

```python
def solution(phone_number):
    return phone_number[-4:].rjust(len(phone_number), "*")
```

👉 [-4:] + rjust = 마스킹 패턴

---

### 8. 핵심 정리

- int(), str(), list() 변환 자유롭게 사용
- slicing ([::-1], [-4:]) 매우 중요
- join / sort / index 자주 사용
- Python은 “구현”보다 “내장함수 활용”이 핵심

---

## 🚀 Summary

- 문자열 ↔ 숫자 ↔ 리스트 변환 패턴 숙지
- slicing + join + sort 조합이 Level 1 핵심
- 직접 구현보다 Python built-in 활용이 중요
