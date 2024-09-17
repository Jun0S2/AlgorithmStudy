/**
 * @date 2024.09.17
 * @author June Park
 * N과 M : 백트랙킹 문제
 * 중복 없이 순서대로 출력
 */
#include <iostream>
#include <array>
using namespace std;
int N, M; // size, selected size
int selected[8];
bool visited[8];

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
        // clear selected

        return; // backtracking
    }
    else
    {
        for (int i = 1; i <= N; i++)
        {
            if (visited[i])
                continue;
            visited[i] = true;
            selected[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}

int main()
{
    cin >> N >> M;
    dfs(0); // 0번째 원소 부터 채운다.

    return 0;
}
