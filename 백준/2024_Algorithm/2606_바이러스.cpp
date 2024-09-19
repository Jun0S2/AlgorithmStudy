/**
 * https://www.acmicpc.net/problem/2606
 * 일반 그래프
 */

#include <iostream>
#include <vector>
using namespace std;

int N; // 컴퓨터 수
int M; // 연결된 컴퓨터의 간선
vector<vector<int>> computers;
vector<bool> visited;
int infected = 0;

void dfs(int start)
{
    visited[start] = true;
    infected++; // 이 컴퓨터는 감염됨
    // 얘랑 인접한 애들은 전부 감염됨
    for (int i = 0; i < computers[start].size(); i++)
    {
        int next = computers[start][i];
        if (!visited[next])
            dfs(next); // dfs(next) 호출
    }
}
int main()
{
    cin >> N;
    cin >> M;

    computers.resize(N + 1);
    visited.resize(N + 1, false);

    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        computers[u].push_back(v);
        computers[v].push_back(u); // visited 배열을 통해 중복 처리
    }

    int answer = 0;

    dfs(1); // 1    번 컴퓨터가 바이러스에 걸림

    cout << (infected - 1) << endl; // 첫번째 컴퓨터 제외

    return 0;
}