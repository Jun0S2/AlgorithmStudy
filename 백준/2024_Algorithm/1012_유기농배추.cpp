/**
 * @date 2024.09.19
 * @author June Park
 * https://www.acmicpc.net/problem/1012
 * Silver 2
 * 격자형 그래프
 */

#include <queue>
#include <iostream>
#include <vector>
using namespace std;

int T; // TC
int M; // 배추밭의 가로 길이
int N; // 배추밭의 세로 길이
int K; // 배추가 심어져 있는 위치의 개수
vector<vector<bool>> board;
vector<vector<bool>> visited;

void bfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push({x, y}); // 배추~
    visited[x][y] = true;

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (visited[nx][ny])
                continue;
            if (!board[nx][ny])
                continue;

            q.push({nx, ny});
            visited[nx][ny] = true; // 최소 한마리 필요하지만, visited 영역 표시를 위해 계속돌린다
        }
    }
}

void solve()
{
    int answer = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (board[i][j] && !visited[i][j])
            {
                bfs(i, j);
                answer++;
            }
        }
    }
    cout << answer << '\n';
}
void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> M >> N >> K;
        board.assign(N, vector<bool>(M, false));
        visited.assign(N, vector<bool>(M, false));
        for (int i = 0; i < K; i++)
        {
            int x, y;
            cin >> x >> y;
            board[y][x] = true;
        }
        solve();
    }
}
int main()
{
    getInput();
    return 0;
}