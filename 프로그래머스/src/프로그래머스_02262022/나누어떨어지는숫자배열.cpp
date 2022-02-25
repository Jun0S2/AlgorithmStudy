#include <string>
#include <vector>

using namespace std;
vector<int> answer;
/*algorithm 안사용하기 위해 counting sort 구현...*/
void sort(int max)
{
    vector<bool> sorting(max + 1, false);
    for (auto a : answer)
        sorting[a] = true;
    int cnt = 0;

    for (int i = 0; i < sorting.size(); i++)
    {
        if (sorting[i])
        {
            answer[cnt] = i;
            sorting[i] = false;
            cnt++;
        }
    }
}
vector<int> solution(vector<int> arr, int divisor)
{
    bool none = true;
    int max = -1;
    for (auto a : arr)
    {
        if (a % divisor == 0)
        {
            answer.emplace_back(a);
            none = false;
            max = max > a ? max : a;
        }
    }
    if (none)
        return {-1};
    sort(max);
    return answer;
}