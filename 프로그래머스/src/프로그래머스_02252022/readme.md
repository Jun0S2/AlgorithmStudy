# 없는 숫자 더하기

처음에는 unordered_map으로 풀으려했는데, 다시 생각해보니 간단한 array[cnt++] 문제였다.

# 소수 만들기

## 📝배운점📝

어제부터 function을 만들고 사용하고 싶었는데 그럴 때 마다,
`Use of undeclared identifier 'FunctionName'` 오류가 발생하였다.

분명 C를 사용할 때, function도 따로 빼서 잘 썼던 것 같은데 왜 자꾸 던지는지 모르겠어서 solution() 안에서 해결하다가 오늘 백트래킹을 사용하기 위해 인터넷을 찾아봤다.

https://stackoverflow.com/questions/17098515/use-of-undeclared-identifier-functionname-c-xcode

답이 너무 빨리 나와서 놀랐고 정말 이걸 잊은 내 자신이 자랑스럽다 ^^..
**fucntion을 declare 할 때, call 하는 함수보다 위쪽에 define 되어있어야하는데**, 자바와 파이썬이 우쭈쭈해주다보니 solution 함수 아래에 계속 적고 왜 안되는지 눈물을 흘리고 있었다. 다시는 안잊을것같다 ^^

## 풀이 방식

level 1 문제인데 백트랙킹이 나와서 흠칫했지만 어렵지 않아서 그러려니 했다. 문제 풀이 후, 다른 사람의 풀이 보기를 했는데 다들 백트래킹이 아니라 삼중 for loop로 쉽게 해결한 것을 보았다. 뇌가 삼전 기출문제에 절여져 있는지 왜 자꾸 백트랙킹, bfs, dfs만 보이는지 모르겠다 ^^;;

# 내적

내적이 뭔지 몰라서 안풀고 있다가, 문제 안의 링크를 타고 들어가보니 위키피디아왈 `내적` == `Dot Product` 였다. 어려워보였는데 속은 기분이다.

# 크레인 인형 뽑기

c++에서 vector의 back() 과 pop_back() 함수를 사용하였더니 매우 편리하게 풀렸다.

# 가운데 글자 가져오기

## (문자열).substr(index, size);

두번째 파라미터에 사이즈가 오는 줄 모르고 end index 찍었다가 계속 헤맸다.
