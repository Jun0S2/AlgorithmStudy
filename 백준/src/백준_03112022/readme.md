# 나는야 포켓몬 마스터 이다솜

## map<string,int>m => m["hello"] = 1; 가능

이게 가능하다는걸 계속 까먹는다..

## 시간초과 해결

```cpp

 ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
```

정말 문제는 별거 없었는데 계속 시간초과가났다.
위 코드를 넣으니 시간초과가 안났다..<<??
혹시 몰라 모든 코드에 넣어봤는데 마법같이 해결된다..쥴쥴..

https://jaimemin.tistory.com/1521

블로그에서 이 세가지에 대해 좀 더 찾아보았다..

자바의 버퍼드 리더같은것인가보다..계속 쓰는 버릇을 가져야겠다.. 요즘 프로그래머스에서만 작성하다 보니 ip/op 관리를 안했는데 정말 눈물난다..

# 패션왕 신해빈

수학 문제 :경우의수구하기

경우의수 (타입 +1(공집합)) \* (타입2 +1) .... -1(전체공집합)

# 팰린드롬 만들기

1. 정렬
2. 모든 글자가 짝수여야 함 -> except when size == 홀수

   -> 짝수 홀수 신경 안쓰고 bool값으로 플래그를 두개 주었다.
   만약, 짝이 안맞는다면? 하나 플래그 on

   이미 플래그가 서있는데도 짝이 안맞는다면 ? 불가능

# 주몽

중간에 탐색하는 코드를 넣어서 혹시 시간초과나면 힙을 써야하는 문제인지 고민했는데 시간초과가 나지 않았다..휴..계속 배열에서 지워줘서 그래도 좀 시간초과가 적었던것같다.

1. 인풋 받기
2. 인풋 - M = 타겟값
3. `원본 인풋`이 배열에 없다면 연산된 `타겟`을 배열에 넣는다.
4. 있다면, cnt++와 배열에서 타겟을 제거해낸다.
5. 반복 후 cnt 출력

# 좋은 단어

아쉬운 부분 : 졸려서 글자수가 2 이하인부분들을 하드코딩했다.

접근 : 겹치지 않으려면 바로 옆에 있으면 된다.
즉, 바로 옆에 연속된 문자가 있으면 둘을 지우고 다시 처음부터 iterate. 뭔가 프로그래머스에서 자주 보던 유형이다

# 곱셈

분할 정복으로 풀었다.

# 1

수학 문제인 것 같다.
여러 블로그를 참고해서 여차여차 풀었지만 아직도 문제가 잘 이해되지 않는다. 비둘기집 원리가 왜 나오는건지..

수학을 좀 더 공부해봐야할것같다..

```cpp
//(A+B)%C 와 (A%C + B%C) %C는 같다
int main(){
    ios::sync_with_stdio(0);
	cin.tie(0);
    int N;
    while(cin>>N){
        int cnt  =  1;
        int temp = 1;
        while(true)
        {
            if(temp % N ==0 )break;
            cnt++;
            temp = ((temp*10)+1)%N;//다음 자리수
        }
        cout<<cnt<<"\n";
    }
}
```
