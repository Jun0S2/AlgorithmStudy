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

https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=python3
https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=python3

```python
def solution(s):
zeros = 0
cnt = 0

    while(len(s)>1):
        cnt += 1
        zeros += s.count("0")
        s = s.replace("0","") # string은 immutable이라 새로 assign
        # 0 제거 후 길이를 이진수로 변환해야함
        s = bin(len(s))[2:]

    return [cnt, zeros] #이진 변환 횟수, 제거된 0의 개수
```

https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=python3
투포인터

```python
def solution(n):
    answer = 0
    start, end = 1, 1
    total = 1

    while start <= n:
        if total == n:
            answer += 1
            total -= start
            start += 1

        elif total < n:
            end += 1
            total += end

        else:
            total -= start
            start += 1

    return answer
```

https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=python3
바로 str에서 count('char') 가능
return bin(x).count('1')

https://school.programmers.co.kr/learn/courses/30/lessons/12945?language=python3

```python
def solution(n):
answer = 0 # base case : F(0), F(1)
fibo = [0,1]

    # (a + b) % M = ((a % M) + (b % M)) % M
    for x in range(2,n+1):
        fibo.append((fibo[x-2]+fibo[x-1])%1234567)

    return fibo[n]
```
