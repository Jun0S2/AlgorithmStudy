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
`stoi(str) -> int`로 바꾸어주고,
`to_string() -> str`로 바꾸어준다 (to_string없이 숫자를 문자열에 더하니까 core dumped 라는 오류가 출력되었다 ㅠ!)

해당 기능으로 다시 코드를 구성하니 벡터 하나가 사라져서 조금 더 나아진것 같다.
