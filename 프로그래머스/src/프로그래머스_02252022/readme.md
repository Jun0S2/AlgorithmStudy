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

# 폰켓몬

처음에는, backtracking을 활용하여 풀었다.

완전 열심히 풀었고, cnt ==m 이 되는 조건에서, 중복인지 판단하였다...

문제의 코드 :

```cpp

void backtracking(int cnt, int start, int m, vector<int> result, vector<int> nums, vector<bool> visited)
{
    if (cnt == m)
    {
        // print(visited);
        int counter = 0;
        for (int i = 0; i < result.size(); i++)
        {
            if (i == 0)
                counter++;
            else
            {
                for (int j = 0; j < i; j++) //중복 확인용
                {
                    if (result[i] == result[j]) //중복이 있었다면
                    {
                        counter--;
                        break;
                    }
                }
                //위 조건에서 break문에서 튕기지 않았다면 counter++
                counter++;
            }
        }
        MAX = MAX < counter ? counter : MAX;
        result.clear();
        return;
    }
    for (int i = start; i < nums.size(); i++)
    {

        if (visited[i])
            continue; //이미 뽑음
        visited[i] = true;
        result.push_back(nums[i]);
        backtracking(++cnt, i + 1, m, result, nums, visited);
        cnt--;
        result.pop_back();
        visited[i] = false;
    }
}

```

일단, `가장 많은 종류` 라는 단어가 삼전 기출이 기른 나에게는 `백트래킹`을 쓰세요 라고 다가왔다. 하지만 3번 이후는 시간초과가 나서 풀지 못했다.

두번째 접근 방식은, 중복 체크를 백트래킹 안에서 하지 않고 메인에서 실행한 후 이미 중복체크가 되어있는 벡터를 백트래킹에 넘겨주는 것이다.

하지만 이 방법으로 풀다보니... 아예 백트래킹 자체가 필요가 없다는걸 깨달았다.

main에서 중복제거를 한 후, 기존 벡터/2 보다 사이즈가 크면 기존벡터사이즈/2 마리 까지만 고를 수 있는게 답이고 아닐 경우는 중복체크가 끝난 벡터의 사이즈만 반환하면 끝나는 문제였다.

```cpp

int solution(vector<int> nums)
{
    vector<int> num2; //처음부터 중복을 제거
    for (int i = 0; i < nums.size(); i++)
    {
        if (i == 0)
            num2.emplace_back(nums[i]);
        else
        {
            bool dup = false; //중복 아님
            for (int j = 0; j < num2.size(); j++)
            {
                if (nums[i] == num2[j])
                {
                    dup = true;
                    break;
                }
            }
            if (!dup)
                num2.emplace_back(nums[i]);
        }
    }

    //생각해보니..unique를 제거하면.. 더이상 백트랙킹이 필요 없다.>!
    return  nums.size() / 2; < num2.size() ?  nums.size() / 2; : num2.size();
}

```

너무나도 심플해져버린 코드...

unique를 사용하면 더 간단할 것 같지만, 가능하면 주어진 헤더로만 풀려고 노력중이기 때문에 그냥 이중 for loop을 돌렸다.
