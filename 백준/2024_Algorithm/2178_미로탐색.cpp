/**
 * @date 2024.09.19
 * @author June Park
 * BFS 최단거리 구하기
 * https://acmicpc.net/problem/2178
 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int N, M;
vector<vector<int>> board;
vector<vector<int>> dist;
vector<vector<bool>> visited;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
void print()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cout << dist[i][j] << " ";
        }
        cout << "\n";
    }
}

void bfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;
    dist[x][y] = 1; // 아항..

    while (!q.empty())
    {
        int xx = q.front().first;
        int yy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = xx + dx[i];
            int ny = yy + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] == 1)
            {
                q.push({nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[xx][yy] + 1;
            }
        }
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);
    cin >> N >> M;
    board.assign(N, vector<int>(M));
    visited.assign(N, vector<bool>(M, false));
    dist.assign(N, vector<int>(M, 0));

    for (int i = 0; i < N; i++)
    {
        string line;
        cin >> line;
        for (int j = 0; j < M; j++)
        {
            board[i][j] = line[j] - '0';
        }
    }
    bfs(0, 0);
    cout << dist[N - 1][M - 1] << "\n";
}