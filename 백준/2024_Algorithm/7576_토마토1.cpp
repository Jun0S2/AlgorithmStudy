/**
 * https://www.acmicpc.net/problem/7576
 * 하루가 지나면 감염
 */
#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int N, M; // size
vector<vector<int>> tomatos;
vector<vector<int>> dist;
queue<pair<int, int>> q;

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

void bfs()
{
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
            if (tomatos[nx][ny] == 1) // 이미 익음
                continue;
            if (tomatos[nx][ny] == -1)
                continue;                  // 토마토가 없음
            tomatos[nx][ny] = 1;           // 익힘
            dist[nx][ny] = dist[x][y] + 1; // 날짜추가
            q.push({nx, ny});
        }
    }
}

int main()
{
    cin >> M >> N;
    tomatos.assign(N, vector<int>(M, 0));
    dist.assign(N, vector<int>(M, 0));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> tomatos[i][j];
            if (tomatos[i][j] == 1) // 익어있는 애들 == 시작bfs
            {
                q.push({i, j});
            }
        }
    }
    bfs();
    int days = -1;
    // 가장 많은 날짜를 찾으면 됌
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (tomatos[i][j] == 0)
            { // 불가 케이스
                cout << "-1\n";
                return 0;
            }
            days = max(days, dist[i][j]);
        }
    }
    cout << days << "\n";
    return 0;
}