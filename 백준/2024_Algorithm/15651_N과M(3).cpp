/**
 * @date 2024.09.17
 * @author June Park
 * N과 M : 백트랙킹 문제
 * 중복 허용 순서대로 출력
 */
#include <iostream>
#include <array>

using namespace std;
int N, M; // size, selected size
int selected[8];

/**
 * @brief Prints out selected values
 */
void dfs(int depth)
{
    // End Case
    if (depth == M)
    {
        for (int i = 0; i < depth; i++)
        {
            cout << selected[i] << " ";
        }
        cout << "\n";
        return; // backtracking
    }
    else
    {
        for (int i = 1; i <= N; i++)
        {
            selected[depth] = i;
            dfs(depth + 1); // 다음 원소 채움
        }
    }
}

int main()
{
    cin >> N >> M;
    dfs(0); // 0번째 원소 부터 채운다.

    return 0;
}
