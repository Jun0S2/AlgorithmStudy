/**
 * @date 2024.09.18
 * @author June Park
 *
 */
#include <iostream>
#include <array>

using namespace std;

int N, S;
int arr[20];
int answer = 0;
void dfs(int depth, int calculated)
{
    if (depth == N)
    {
        if (calculated == S)
            answer++;
        return;
    }
    else
    {
        dfs(depth + 1, calculated + arr[depth]); // 고르거나
        dfs(depth + 1, calculated);              // 고르지 않거나
    }
}
int main()
{
    cin >> N >> S;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    dfs(0, 0);
    if (S == 0)
        answer--; // 공집합
    cout << answer;
    return 0;
}