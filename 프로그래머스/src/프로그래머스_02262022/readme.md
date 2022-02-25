# 소수찾기

소수찾기는 항상 따라오는 것 같다.
잊을만 하면 에라토스테네스의 체가..

소수 찾는 문제는 항상 느끼는 거지만, 시간 초과 문제인 것 같다. 미리 에라토스테네스의 체로 배열에 소수인지 아닌지 10^6 까지 판단해놓고 given 범위까지 세는 것이 시간초과가 안나는 것 같다.

## 알고리즘

### isPrime 배열

```cpp

vector<bool> isPrime(1000000 , true);

```

`isPrime` 배열을 static으로 선언한다. c++도 static 이라고 하는지 모르겠지만 바깥에다가 선언해주었다.

- isPrime = true when number is prime
- isPrimie = false when numbe is NOT prime

이름 그대로의 배열이다

### 2부터 시작하며 소수인지 판단

에라토스테네스의 체에서는, 만약 어떤 숫자가 소수이면 (현재 모든 숫자가 소수인 상태!) 그 숫자의 제곱수들은 소수가 아니기 때문에, 이 숫자들을 배열에서 false 로 바꾸어 준다.

이 과정을 반복하다보면 `isPrime` 배열이 완성된다

```cpp

    for (int i = 2; i * i < 1000000; i++)
    {
        if (isPrime[i]) //소수인 수 발견 -> 이제 이 숫자의
            for (int j = i * i; j <= 1000000; j += i)
            {
                isPrime[j] = false;
            }
    }

```

### N 까지의 숫자 중 소수인 수의 개수

이제, 이미 소수인지 아닌지 배열이 생겼기 때문에, for loop 하나를 돌려서 직접 카운트 하면 된다.

```cpp
  for (int i = 2; i <= n; i++)
    {
        if (isPrime[i])
            cnt++;
    }
```
