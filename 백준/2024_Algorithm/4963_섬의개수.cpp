#include <queue>
#include <iostream>
#include <vector>
using namespace std;

/**
 * @date 2024.09.19
 * @author June Park
 * Silver 2
 * 문제 input 순서때문에 한참 해맸다
 * https://www.acmicpc.net/problem/4963
 */
int N; // height (높이)
int M; // width (너비)
vector<vector<bool>> island;
vector<vector<bool>> visited;
int answer = 0; // 섬 개수

// 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하 8방향
int dx[] = {-1, 1, 0, 0, -1, 1, -1, 1};
int dy[] = {0, 0, -1, 1, -1, -1, 1, 1};

void bfs(int x, int y)
{
    visited[x][y] = true;
    queue<pair<int, int>> q;
    q.push({x, y});

    while (!q.empty())
    {
        int node_x = q.front().first;
        int node_y = q.front().second;
        q.pop();

        for (int d = 0; d < 8; d++)
        {
            int nx = node_x + dx[d];
            int ny = node_y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (visited[nx][ny] || !island[nx][ny])
                continue;

            visited[nx][ny] = true;
            q.push({nx, ny}); // 다음 노드
        }
    }
}

void solve()
{
    answer = 0;
    for (int i = 0; i < N; i++) // 높이
    {
        for (int j = 0; j < M; j++) // 너비
        {
            if (!visited[i][j] && island[i][j]) // 방문하지 않은 섬 찾기
            {
                bfs(i, j);
                answer++; // 섬 개수 증가
            }
        }
    }
    cout << answer << '\n'; // 결과 출력
}

void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    while (true)
    {
        cin >> M >> N; // 너비 M, 높이 N 입력 (주의: 순서가 M, N임)
        if (M == 0 && N == 0)
            break; // 입력 종료 조건

        // 벡터 크기 초기화
        island.assign(N, vector<bool>(M, false));  // 높이 N, 너비 M으로 초기화
        visited.assign(N, vector<bool>(M, false)); // 높이 N, 너비 M으로 초기화

        for (int i = 0; i < N; i++) // 높이만큼 반복
        {
            for (int j = 0; j < M; j++) // 너비만큼 반복
            {
                int isIsland;
                cin >> isIsland;
                island[i][j] = (isIsland == 1); // 1이면 섬, 0이면 바다
            }
        }
        solve(); // 섬 개수 계산
    }
}

int main()
{
    getInput();
    return 0;
}
