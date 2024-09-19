/**
 * @date 2024.09.19
 * @author June Park
 * https://www.acmicpc.net/problem/11724
 * Silver 2
 * 격자형 그래프
 */

#include <queue>
#include <iostream>
#include <vector>
using namespace std;
int N; // 정점의 개수
int M; // 간선의 개수
vector<vector<bool>> graph;
vector<bool> visited;
int answer = 0; // 연결 요소
void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> M;

    graph.assign(N + 1, vector<bool>(N + 1, false));
    visited.assign(N + 1, false);
    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u][v] = graph[v][u] = true;
    }
}

void dfs(int start)
{
    visited[start] = true;
    if (start == N + 1)
    {
        return;
    }
    for (int i = 1; i <= N; i++)
    {
        if (visited[i])
            continue;
        if (!graph[start][i])
            continue;
        dfs(i); // next node
    }
}
void bfs(int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;
    while (!q.empty())
    {
        int node = q.front(); // 지금 방문중인 노드
        q.pop();
        // 현재 정점 node 와 연결된 모든 이웃 정점 확인
        for (int i = 1; i <= N; i++)
        {
            if (visited[i]) // 이미 방문
                continue;
            if (!graph[node][i]) // 간선 없음
                continue;
            // else
            visited[i] = true;
            q.push(i); // 방문하지 않은 이웃 정점을 큐에 추가
        }
    }
}
void solve()
{
    for (int i = 1; i <= N; i++)
    {

        if (visited[i]) // bfs한번 돌면 방문 노드 추가중
            continue;   // 이미 방문한 정점
        // bfs(i);         // 방문한 노드만
        dfs(i);
        answer++; // 연결요소 개수 추가
    }
    cout << answer << '\n';
}
int main()
{
    getInput();
    solve();
    return 0;
}