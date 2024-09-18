#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int N; // 정점의 개수
int M; // 간선의 개수
int V; // 시작 정점의 번호

vector<bool> visited;
bool board[1001][1001];

void bfs(int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;

    while (!q.empty())
    {
        int here = q.front();
        q.pop();
        cout << here << " ";

        for (int i = 1; i <= N; i++)
        {
            if (!board[here][i])
                continue; // 연결 안되어있음
            if (visited[i] == true)
                continue; // 이미 방문 함
            q.push(i);
            visited[i] = true;
        }
    }
}

void dfs(int start)
{
    visited[start] = true;
    cout << start << " "; // 방문한 정점 출력

    // x 에서 갈 수 있는 정점을 탐색
    for (int i = 1; i <= N; i++)
    {
        if (!board[start][i])
            continue; // 갈 수 없음
        if (visited[i] == true)
            continue; // 이미 방문 함
        dfs(i);       // 다음 노드
    }
}

void input()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> M >> V;           // 시작 정점 V도 입력받음
    visited.resize(N + 1, false); // 정점은 1부터 시작하므로 N+1로 설정
    int vertex, vertex2;
    for (int i = 1; i <= M; i++)
    {
        cin >> vertex >> vertex2;
        board[vertex][vertex2] = board[vertex2][vertex] = true; // 양방향 간선
    }
}

int main()
{
    input(); // 입력 받기

    dfs(V); // 시작 정점 V로 DFS 실행
    cout << "\n";

    visited.assign(N + 1, false); // BFS를 위한 visited 초기화
    bfs(V);                       // 시작 정점 V로 BFS 실행

    return 0;
}
