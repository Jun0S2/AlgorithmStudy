#include <vector>
#include <iostream>

using namespace std;
/*vector만 사용하여 문제를 풀려 했으나 시간초과가 난다 ^^*/

void print(vector<bool> arr)
{
    for (auto a : arr)
        cout << a << " ";
    cout << endl;
}
int MAX = 0;
//가장 다양한 종류를 고르고 싶다고 하네요. 백트래킹 써야겠다
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

int solution(vector<int> nums)
{
    vector<int> result;
    vector<bool> visited(nums.size(), false);

    backtracking(0, 0, nums.size() / 2, result, nums, visited);

    return MAX;
}