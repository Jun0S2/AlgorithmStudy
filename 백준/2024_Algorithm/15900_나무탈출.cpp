/**
 * @date 2024.09.22
 * @author June Park
 * 실버 1
 * https://www.acmicpc.net/problem/15900
 * 연습필요
 */
#include <iostream>
#include <vector>

using namespace std;

int N;                            // 정점의 개수
vector<vector<int>> tree(500001); // 트리 구조
vector<bool> visited(500001);     // 방문 체크
int totalDepth = 0;               // 리프 노드까지의 깊이 합

// 입력을 처리하는 함수
void getInput()
{
    cin >> N;                       // 정점의 개수
    for (int i = 0; i < N - 1; i++) // 간선은 N-1개
    {
        int u, v;
        cin >> u >> v;
        tree[u].push_back(v); // u번 정점과 v번 정점을 연결
        tree[v].push_back(u); // 트리는 무방향이므로 양방향 연결
    }
}

// DFS로 리프 노드까지의 거리 합을 계산
void dfs(int node, int depth)
{
    visited[node] = true; // 현재 노드 방문 처리
    bool isLeaf = true;   // 자식이 없는 노드인지 확인

    for (auto next : tree[node]) // 현재 노드의 인접 노드를 순회
    {
        if (!visited[next]) // 방문하지 않은 노드만 처리
        {
            isLeaf = false;       // 자식이 있으면 리프 노드가 아님
            dfs(next, depth + 1); // 자식 노드로 이동하며 깊이 증가
        }
    }

    // 리프 노드이면 그 깊이를 합산
    if (isLeaf)
    {
        totalDepth += depth;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    getInput(); // 입력 받기
    dfs(1, 0);  // 1번 노드에서 DFS 탐색 시작

    // 리프 노드까지의 거리의 총합이 홀수면 성원이 승리
    cout << (totalDepth % 2 == 0 ? "No" : "Yes") << '\n';
    return 0;
}
