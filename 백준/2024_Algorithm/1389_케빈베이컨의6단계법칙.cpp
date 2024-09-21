/**
 * @date 2024.09.21
 * @author June Park
 * https://www.acmicpc.net/problem/1389
 * Silver 1
 * 그래프 깊이 문제..?
 * 최단 경로는 무조건 bfs
 */

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N, M; // 유저의 수 간선의 수
vector<vector<int>> relations;
vector<int> answers; // 베이컨리스트

void getInput()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> M;
    answers.resize(N + 1, 0);
    relations.resize(N + 1);
    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        relations[u].push_back(v);
        relations[v].push_back(u);
    }
}
void bfs(int start)
{
    queue<pair<int, int>> q; //   node, distance
    vector<bool> visited(N + 1, false);
    q.push({start, 0});
    visited[start] = true;
    int totalDistance = 0; // 총 누적 거리

    while (!q.empty())
    {
        int current = q.front().first;
        int dist = q.front().second;
        q.pop();

        // 현재 노드까지의 거리
        totalDistance += dist;

        for (int next : relations[current])
        {
            if (!visited[next])
            {
                visited[next] = true;
                q.push({next, dist + 1});
            }
        }
    }
    answers[start] = totalDistance; // bacon index
}

void solve()
{
    for (int i = 1; i <= N; i++)
    {
        bfs(i);
    }

    int minBacon = *min_element(answers.begin() + 1, answers.end()); // 1부터
    for (int i = 1; i <= N; i++)
    {
        if (answers[i] == minBacon)
        {
            cout << i << '\n';
            return;
        }
    }
}
int main()
{
    getInput();
    solve();
}
