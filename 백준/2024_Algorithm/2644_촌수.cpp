/**
 * @date 2024.09.19
 * @author June Park
 * https://www.acmicpc.net/problem/2644
 * Silver 2
 * 느낀점 : 일반 그래프 문제는, 방문배열은 1차원이고 관계배열이 2차원.
 * dfs 일반케이스에서 관계배열[인덱스].size() 를 iterte,
 * for loop 의 인덱스에서 다음 원소를 꺼내서, 그 꺼낸 원소를 dfs 조건식에서 사용함
 *
 */
#include <iostream>
#include <vector>

using namespace std;

int N;                // 사람 수
int startptr, endptr; // 관계를 찾을 두 사람
int M;                // 간선(관계) 수
vector<vector<int>> family;
vector<bool> visited;
int ans = -1; // 최종 촌수 (못찾을 경우 -1 출력)

void dfs(int index, int count)
{
    // end case: 목표 사람에 도달하면 촌수 기록
    if (index == endptr)
    {
        ans = count;
        return;
    }

    // 연결된 사람들 탐색
    for (int i = 0; i < family[index].size(); i++)
    {
        int next = family[index][i];
        if (!visited[next])
        {
            visited[next] = true;
            dfs(next, count + 1);
            visited[next] = false;
        }
    }
}

void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> startptr >> endptr >> M;

    family.assign(N + 1, vector<int>()); // N명의 사람 관계
    visited.assign(N + 1, false);        // 방문 여부

    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        family[a].push_back(b);
        family[b].push_back(a);
    }
}

int main()
{
    getInput();
    visited[startptr] = true; // 시작점 방문 처리
    dfs(startptr, 0);         // 시작점에서 탐색 시작

    cout << ans << "\n"; // 촌수 출력 (못 찾으면 -1)
    return 0;
}
