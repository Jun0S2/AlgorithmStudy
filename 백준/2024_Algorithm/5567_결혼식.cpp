/**
 * @date 2024.09.21
 * @author June Park
 * Silver 2
 * 방문 : 1차원 백터
 * 노드 : 2차원 리스트
 * https://www.acmicpc.net/problem/5567
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M;
vector<vector<int>> friends;
int invitations;
void getInput()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> M;
    friends.resize(N + 1);

    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        friends[u].push_back(v);
        friends[v].push_back(u);
    }
}

// 상근이는 1 이래
void bfs(int start)
{
    //    queue<int> q;
    vector<bool> visited(N + 1, false);
    queue<pair<int, int>> q; // 노드, 탐색 깊이

    q.push({start, 0}); // 상근이, 깊이 0
    visited[start] = true;

    while (!q.empty())
    {
        int current = q.front().first;
        int depth = q.front().second;
        q.pop();

        if (depth > 2)
            continue;  // 깊이 2 넘어가면 상근이 친구가 아님 (친구의 친구만 2촌)
        if (depth > 0) // 1 단계나 2단계친구만
        {
            invitations++;
        }
        for (auto v : friends[current])
        {
            if (visited[v])
                continue; // 이미 방문한 친구
            visited[v] = true;
            q.push({v, depth + 1}); // 새친구
        }
    }
}

void solve()
{
    invitations = 0;
    bfs(1);
    cout << invitations << '\n';
}
int main()
{
    getInput();
    solve();
}