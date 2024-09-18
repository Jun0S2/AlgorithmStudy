/**
 * @date 2024.09.18
 * @author June Park
 * 연산자 끼워넣기 dfs
 */

#include <iostream>
#include <array>

using namespace std;

int N; // 수의 개수 2~11
int arr[12];
int operators[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
int minValue = 1000000000;
int maxValue = -1000000000;

void dfs(int depth, int calculated)
{
    if (depth == N)
    {
        minValue = calculated < minValue ? calculated : minValue;
        maxValue = calculated > maxValue ? calculated : maxValue;
        return;
    }
    else
    {
        // +,-,*,/ 의 조합을 구한다.
        for (int i = 0; i < 4; i++)
        {
            if (operators[i] > 0)
            {                   // 아직 남아있음
                operators[i]--; // 선택
                if (i == 0)
                    dfs(depth + 1, arr[depth] + calculated); // 다음 숫자와 더함
                else if (i == 1)
                    dfs(depth + 1, calculated - arr[depth]);
                else if (i == 2)
                    dfs(depth + 1, calculated * arr[depth]);
                else if (i == 3)
                    dfs(depth + 1, calculated / arr[depth]);
                operators[i]++; // 해제
            }
        }
    }
}

void getInput()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < 4; i++)
    {
        cin >> operators[i];
    }
}
int main()
{
    getInput();
    dfs(1, arr[0]); // 첫번째 숫자
    cout << maxValue << "\n"
         << minValue;

    return 0;
}