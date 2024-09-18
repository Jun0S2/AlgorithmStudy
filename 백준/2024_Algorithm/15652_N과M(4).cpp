/**
 * @date 2024.09.17
 * @author June Park
 * N과 M : 백트랙킹 문제
 * 중복 허용 비내림차순
 */
#include <iostream>
#include <array>
using namespace std;
int N, M; // size, selected size
int largest = 0;
int selected[8];
/**
 * @brief Prints out selected values
 */

void init()
{
    for (int i = 0; i <= M; i++)
    {
        selected[i] = 0;
    }
}

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
            // 마지막 원소가 i 보다 작으면 continue
            if ((depth > 0) && (selected[depth - 1] > i))
                continue;
            selected[depth] = i;
            dfs(depth + 1);
        }
    }
}

int main()
{
    cin >> N >> M;
    init();
    dfs(0); // 0번째 원소 부터 채운다.

    return 0;
}
