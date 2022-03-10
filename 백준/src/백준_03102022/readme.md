# 일곱난쟁이

dfs로 풀이

1. sort
2. 입력 받을 때, 모든 수 더한 후 -100 = 찾으려는 두 난쟁이의 키의 합
3. dfs로 순열
4. if targetSum == sum 프린트하고 종료

# 알파벳 개수

```cpp
 for(char &c : str) alphabets[c-'a']++;
```
