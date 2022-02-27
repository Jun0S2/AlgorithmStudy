# 문자열 내 마음대로 정하기

문제를 보고 자바로는 풀 수 있는데, 아직 C++ 기초가 부족해서 그런지 오버라이딩을 어떻게 할 지 감이 안잡혔다. 찾아보니 algorithm 헤더를 반드시 써야하는 문제 같았고 오버라이딩 방식이 특이해서 기록으로 남긴다.

## sort

```cpp
sort(vec.begin(), vec.end(), compare); //3번째에 비교방법을 기술한 함수를 쓴다!
```

### compare 함수

이름은 상관 없다.

```cpp
int N;

bool compare(string s1 , string s2)
{
    if(s1[N]==s2[N]) return s1 < s2; //오름차순
    else return s1[N] < s2[N];
}
```

딱히 @override 같은 형식은 없다.

자바에서는 o1 - o2 로 반환했지만 c++에서는 `str1 < str2` 와 같이 부등호를 사용하여 반환한다!

### string[index]

또, 방금 알게 되었는데 문자열[인덱스] == charAt과 동일하다 ㅇㅁㅇ!

# 문자열 내림차순으로 정렬하기

```cpp
sort(s.begin(), s.end(), greater<char>());
or
sort(s.rbegin(),s.rend());
```

위 sort 함수를 사용하면 사용자 정의 함수 없이도 문자열의 char을 정렬할 수 있다.!

# 최대공약수와 최소공배수

while을 사용하여 intuitive한 방식으로 풀었는데 11번과 15번 케이스에서 계속 실패했다. 결국 유클리드 호제법을 이용해서 풀었다.

# 실패율

한시간 넘게 풀었던 것 같다. 나중에 다시 풀어봐야겠다.

문제 조건을 잘 안읽어서 삼십분이 넘도록 왜 안돼는지 이곳저곳 뒤져도 알지 못했다 ㅠㅠ. 분모가 계속 바뀌는 문제였는데 ㅠㅠ

그래도 문제를 풀면서 sort를 이 방법 저 방법으로 연습했다 ㅋㅋ.

## Make Pair

처음보는 아이.. ArrayList<int[]>같은 느낌이다. pair( , ) 을 계속 명시해줘야 한다.

```cpp
 vector<pair<int,double>> failure;
 failure.push_back(make_pair(i,(double)cnt/total));
```

## Sort

```cpp
bool compare(const pair<int,double> &v1 , const pair<int, double> &v2){
    if(v1.second == v2.second) return v1.first < v2.first;
    return v1.second > v2. second; //내림차순
}

...
 sort(failure.begin(), failure.end(), compare);

```

nested 백터에 pair 가 들어가 있어서 `bool compare(const pair<int,double> &v1 , ...)` 이 들어온 상태.
만약, nested 백터에 pair 가 아니라 vector<double>이 들어와 있다면,

```cpp
bool compare(const vector<double> &v1 , const vector<double> &v2)
{...}
```

가 들어오게 된다.

또, 놀랍게도 #include <algorithm> 을 사용하게 되면 swap(index , index) 가 가능하더라..
