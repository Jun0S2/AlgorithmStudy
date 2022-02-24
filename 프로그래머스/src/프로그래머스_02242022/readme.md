# 로또의 최고순위와 최저순위

자바 방식으로 프로그래밍하였고, vector.push_back을 사용

# 신고결과 받기

C++를 백터까지 공부하고 풀으려고 시도했으나 해쉬맵같은 데이터 구조를 사용해야 할 것 같았고, stringtokenizer 같은 기능이 필요했는데 C++에서 해당 기능을 사용하는 라이브러리도 몰랐고 뭔가 잘 정리되지 않아서 https://wadekang.tistory.com/6 블로그를 보고 공부를 했다.

## 배운 점

### Initialize

```c++
  vector<int> answer(id_list.size(), 0); //초기화
```

vector를 사용할 때, 괄호를 사용하여 사이즈와 특정 값을 미리 초기화 할 수 있다.

### Map

```c++
#include <unordered_map>
#include <set>

unordered_map<string, int> index_map;
unordered_map<string, set<string>> report_map;
report_map["키값"].insert("set안에 들어갈 string");
```

1. set을 value값으로 사용할 때, insert()를 사용

2. first & second

   처음 first , second를 보았을 때에는 변수 이름인줄 알고 해맸다. 찾아보니,
   key : iter->first, value : iter->second 였다...

   즉, report_map_element.second.size() 는 set의 사이즈를 구하는 문장이다.

### MAP VS UNORDERED MAP

Use std::map when

1. You need ordered data.
2. You would have to print/access the data (in sorted order).
3. You need predecessor/successor of elements.

Use std::unordered_map when

1. You need to keep count of some data (Example – strings) and no ordering is required.
2. You need single element access i.e. no traversal.

c++에서도, map의 value 값으로 객체를 줄 수 있다!

### StringStream

```c++
#include <sstream>

stringstream ss;
string word = "첫음절 다음음절";
ss.str(word);

string first, second;//단어를 담을 변수
ss>> first >> second; //문자열 parsing
//결과  : first = "첫음절", second"="다음음절"

```

# 숫자 문자열과 영단어

별로 잘 쓴것 같지 않고 마음에 안든다.
배운점은 아래와 같다

## 문자열.at(i)

문자열.charAt(i) 와 같은 기능

## continue와 break

continue와 break를 둘 다 사용 가능하다!

## stoi() 와 to_string()

코드가 마음에 안들어서 구글에 찾다보니까, stoi() 기능이 있다는걸 깨달았다..!ㅠㅠ
stoi(str) -> int로 바꾸어주고,
to_string() -> str로 바꾸어준다 (to_string없이 숫자를 문자열에 더하니까 core dumped 라는 오류가 출력되었다 ㅠ!)

해당 기능으로 다시 코드를 구성하니 벡터 하나가 사라져서 조금 더 나아진것 같다.

# 키패드 누르기

일단, 접근 방식은 매우 마음에 들었으나 아직 vector에 대해서 잘 이해하지 못해서 2d vector로 만들고 싶었는데 1d 벡터를 네개나 만들어서 풀었다 ㅠㅠ.

접근 방식은, 각 2 5 8 0 에서 각 숫자의 거리를 배열에 저장하는 형식으로 백준에서 구현 문제를 풀 때 자주 사용하던 방식이다.
벡터를 2d로 만들면 불필요한 if-else if-else 문을 많이 제거할 수 있을 것 같다

## 2D Vector

```c++
vector<vector<int>> vect;
vect[i]
```

2D 벡터 사용법을 배웠고..vector안에 vector을 넣다니..상상도 못한 정체 ㄴㅇㄱ

기존의 벡터

```c++
    vector<int> distance2 = {3,1,0,1,2,1,2,3,2,3,4,4};//키패드 2에서 다른 숫자까지(index)의 거리
    vector<int> distance5 = {2,2,1,2,1,0,1,2,1,2,3,3};
    vector<int> distance8 = {1,3,2,3,2,1,2,1,0,1,2,2};
    vector<int> distance0 = {0,4,3,4,3,2,3,2,1,2,1,1};
```

에서

```c++
    vector<vector<int>> distances = {
        {0,4,3,4,3,2,3,2,1,2,1,1}, //0
        {},//1
        {3,1,0,1,2,1,2,3,2,3,4,4},//키패드 2에서 다른 숫자까지(index)의 거리
        {},{},//3 4
        {2,2,1,2,1,0,1,2,1,2,3,3},
        {},{},//6 7
        {1,3,2,3,2,1,2,1,0,1,2,2},
        {}//9
    };
```

로 변경하게 되었다. 이렇게 사용하면, 37-58번째 라인을 없애고

```c++
 int left_distance = distances[numbers[i]][left]; //해당 inner vector 에 접근
 int right_distance = distances[numbers[i]][right];
```

위 두줄로 표현할 수 있다! 좀 더 만족스러운 느낌이 들게 수정하였다. 근데 백터가 좀 신경쓰이긴 하는데 후에 더 좋은 풀이법을 생각해 내고 싶다.
