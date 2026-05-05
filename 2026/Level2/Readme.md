https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=python3

```python

def solution(s):
nums = list(map(int, s.split()))
return f"{min(nums)} {max(nums)}"

# s.split() → "1 2 3 4" → ["1", "2", "3", "4"]
# map(int, arr) → [1, 2, 3, 4]
# min(nums) → 최소값
# max(nums) → 최대값
# f"{min} {max}" → 문자열로 합치기
```
