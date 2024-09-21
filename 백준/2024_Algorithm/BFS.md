# BFS

촌수, 관계를 카운트 해야할 때에는
Queue 를 {node, depth} 로 저장해야한다.

5567 결혼식

```
void bfs(int start)
{
// queue<int> q;
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
```

1389 케빈 베이컨의 6단계

```
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
```

촌수 (dfs)

```
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
```
