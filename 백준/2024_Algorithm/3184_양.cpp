/**
 * @date 2024.09.19
 * @author June Park
 * https://www.acmicpc.net/problem/3184
 * 처음에는 양과 늑대의 좌표를 계산해서 다시 더했는데 바로 할 수 있는 거였다
 */
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int R; // row
int C; // columns
vector<vector<char>> map;
vector<vector<bool>> visited;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int sheep = 0; // 최종 양 개수
int wolf = 0;  // 최종 늑대 개수

void bfs(int x, int y)
{
    int local_sheep = 0;
    int local_wolf = 0; // 현재 영역에서의 양과 늑대 수
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;

    // BFS 탐색
    while (!q.empty())
    {
        int nodex = q.front().first;
        int nodey = q.front().second;
        q.pop();

        // 현재 노드의 정보 업데이트
        if (map[nodex][nodey] == 'o')
            local_sheep++;
        else if (map[nodex][nodey] == 'v')
            local_wolf++;

        for (int d = 0; d < 4; d++)
        {
            int nx = nodex + dx[d];
            int ny = nodey + dy[d];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;
            if (visited[nx][ny] || map[nx][ny] == '#')
                continue;

            visited[nx][ny] = true; // 방문 처리
            q.push({nx, ny});
        }
    }

    // 한 영역에서의 결과 계산
    if (local_sheep > local_wolf)
        sheep += local_sheep; // 양이 더 많으면 양만 생존
    else
        wolf += local_wolf; // 늑대가 더 많으면 늑대만 생존
}

void solve()
{
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if ((map[i][j] == 'o' || map[i][j] == 'v') && !visited[i][j])
            {
                bfs(i, j); // 양이나 늑대를 만난 새로운 영역에서 BFS 시작
            }
        }
    }
    cout << sheep << " " << wolf << '\n'; // 최종 결과 출력
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> R >> C;
    map.assign(R, vector<char>(C, '.'));
    visited.assign(R, vector<bool>(C, false));

    string line;
    for (int i = 0; i < R; i++)
    {
        cin >> line;
        for (int j = 0; j < C; j++)
        {
            map[i][j] = line[j];
        }
    }

    solve(); // 문제 해결 및 결과 출력
}
