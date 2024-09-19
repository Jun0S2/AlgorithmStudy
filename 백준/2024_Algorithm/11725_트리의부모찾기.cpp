/**
 * @date 2024.09.19
 * @author June Park
 * https://www.acmicpc.net/problem/11725
 * Silver 2
 * 일반 그래프
 */

#include <iostream>
#include <vector>

using namespace std;

int N;                    // 노드의 개수
vector<vector<int>> tree; // 인접 리스트 형태로 트리를 표현
vector<int> parent;       // 각 노드의 부모 노드를 저장
vector<bool> visited;     // 노드 방문 여부를 체크

void dfs(int node)
{
    visited[node] = true; // 현재 노드를 방문 처리

    // 현재 노드와 연결된 모든 노드를 탐색
    for (int next : tree[node]) // 1,0 으로 저장되는게 아니라 서로 연결된애들이 저장..
    {
        if (!visited[next])
        {                        // 아직 방문하지 않았다면
            parent[next] = node; // 현재 노드를 부모로 설정
            dfs(next);           // 다음 노드로 재귀적으로 탐색
        }
    }
}

void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    tree.resize(N + 1);
    parent.resize(N + 1);
    visited.resize(N + 1, false);

    // 트리 간선 입력 받기
    for (int i = 1; i < N; i++)
    { // N개의 노드, N-1개의 간선
        int u, v;
        cin >> u >> v;
        tree[u].push_back(v); // 양방향 간선
        tree[v].push_back(u); // 트리이므로 양방향 연결
    }
}

void solve()
{
    dfs(1); // 1번 노드를 루트로 DFS 탐색 시작

    // 2번 노드부터 부모 노드 출력
    for (int i = 2; i <= N; i++)
    {
        cout << parent[i] << '\n';
    }
}

int main()
{
    getInput(); // 입력 처리
    solve();    // 부모 노드 탐색 및 출력
    return 0;
}
