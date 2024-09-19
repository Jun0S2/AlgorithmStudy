/**
 * @date 2024.09.19
 * @author June Park
 * Silver 1
 * https://www.acmicpc.net/problem/7562
 */
#include <queue>
#include <vector>
#include <iostream>

using namespace std;

int TC;
int N;              // 체스판 길이
int curr_x, curr_y; // 나이트의 현재 위치
int goal_x, goal_y; // 나이트가 이동하려는 위치
vector<vector<bool>> visited;
vector<vector<int>> dist;

// 나이트의 8방향 움직임
int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};

void bfs()
{
    visited[curr_x][curr_y] = true;
    queue<pair<int, int>> q;
    q.push({curr_x, curr_y});
    dist[curr_x][curr_y] = 0;

    while (!q.empty())
    {
        int xx = q.front().first;
        int yy = q.front().second;
        q.pop(); // 큐에서 제거

        // 목표 지점에 도달하면 탐색 종료 - 최적화
        if (xx == goal_x && yy == goal_y)
            return;

        // 나이트의 8방향 이동 시도
        for (int d = 0; d < 8; d++)
        {
            int nx = xx + dx[d];
            int ny = yy + dy[d];

            // 체스판의 범위를 벗어나지 않고, 방문하지 않은 곳만 이동
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny])
            {
                dist[nx][ny] = dist[xx][yy] + 1;
                visited[nx][ny] = true;
                q.push({nx, ny});
            }
        }
    }
}

void getInput()
{
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);
    cin >> N;

    // 각 테스트 케이스마다 초기화
    visited.assign(N, vector<bool>(N, false));
    dist.assign(N, vector<int>(N, 0));
    cin >> curr_x >> curr_y >> goal_x >> goal_y;
}

int main()
{
    cin >> TC;
    for (int t = 1; t <= TC; t++)
    {
        getInput();
        bfs();
        cout << dist[goal_x][goal_y] << "\n"; // 목표 지점까지의 최단 거리 출력
    }
    return 0;
}
