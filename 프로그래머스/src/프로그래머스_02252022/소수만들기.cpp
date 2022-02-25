#include <vector>
#include <iostream>
using namespace std;

int counter = 0;

/* Visited 확인 용 Utility
void print(vector<bool> arr)
{
    for (auto a : arr)
        cout << a << " ";
    cout << endl;
}
*/

bool isPrime(int number)
{
    //원소가 1이상이기때문에 6미만의 숫자는 신경 안써도 된다
    for (int i = 2; i < number; i++)
    {
        if (number % i == 0)
            return false;
    }
    return true;
}

/*m==3*/
void backtracking(int sum, int cnt, int start, vector<int> nums, vector<bool> visited)
{
    if (cnt == 3)
    {
        if (isPrime(sum))
            counter++; //합이 소수인지 확인
        return;
    }

    for (int i = start; i < nums.size(); i++)
    {
        if (visited[i])
            continue;
        visited[i] = true;
        backtracking(sum + nums[i], ++cnt, i + 1, nums, visited); // else, 재귀 & visited 해제
        visited[i] = false;
        --cnt;
    }
}

int solution(vector<int> nums)
{
    vector<bool> visited(nums.size(), false);
    backtracking(0, 0, 0, nums, visited);
    return counter;
}