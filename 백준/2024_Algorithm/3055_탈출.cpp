/**
 * @date 2024.09.21
 * @author June Park
 * Gold 4
 * https://www.acmicpc.net/problem/3055
 * .size() 를 쓰지 않으려고 아득바득했는데, 결국 써야하네..
 * 단순한 문제들은 queue 에 depth 를 기록하고있었는데, 결국 size
 * while 안에 size 는 경우의 수의 출발점이라고 할 수 있음.
 * 경우 for loop 안에 일반적으로 쓰던걸 넣으니 됐다.
 */

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int R, C;
vector<vector<char>> map;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int start[] = {0, 0};      // 고슴도치의 위치
int goal[] = {0, 0};       // 비버 집의 위치
vector<vector<int>> water; // 물의 좌표

void getInput()
{
    cin >> R >> C;
    map.resize(R, vector<char>(C));
    string line;
    for (int i = 0; i < R; i++)
    {
        cin >> line;
        for (int j = 0; j < C; j++)
        {
            map[i][j] = line[j];
            if (map[i][j] == 'S')
            {
                start[0] = i;
                start[1] = j;
            }
            else if (map[i][j] == 'D')
            {
                goal[0] = i;
                goal[1] = j;
            }
            else if (map[i][j] == '*')
            {
                water.push_back({i, j});
            }
        }
    }
}

void printMap()
{
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cout << map[i][j] << " ";
        }
        cout << "\n";
    }
}

/**
 * 1 분 후의 세계관
 */
void tictoc()
{
    int waterCases = water.size(); // 미리 케이스만큼만 루프 돌리면, 방문 배열도 필요 없음
    for (int i = 0; i < waterCases; i++)
    {
        int x = water[i][0];
        int y = water[i][1];
        for (int d = 0; d < 4; d++)
        {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;
            if (map[nx][ny] == '.')
            {
                map[nx][ny] = '*';
                water.push_back({nx, ny});
            }
        }
    }
}

int bfs()
{
    queue<pair<int, int>> q;
    vector<vector<bool>> visited(R, vector<bool>(C, false));
    q.push({start[0], start[1]});
    visited[start[0]][start[1]] = true;

    int time = 0;

    while (!q.empty())
    {
        tictoc();                    // 1분 후의 평행세계
        int possibilites = q.size(); // 평행세계의 고슴도치들
        for (int i = 0; i < possibilites; i++)
        {
            int current_x = q.front().first;
            int current_y = q.front().second;
            q.pop();

            for (int d = 0; d < 4; d++)
            {
                int next_x = current_x + dx[d];
                int next_y = current_y + dy[d];
                if (next_x < 0 || next_x >= R || next_y < 0 || next_y >= C || visited[next_x][next_y])
                    continue; // 방문했거나 범위 오류
                if (next_x == goal[0] && next_y == goal[1])
                {
                    return (time + 1); // 도착
                }
                if (map[next_x][next_y] == '.')
                {
                    visited[next_x][next_y] = true;
                    q.push({next_x, next_y});
                }
            }
        }
        time++;
    }
    return -1;
}

void solve()
{
    int result = bfs();
    if (result == -1)
        cout << "KAKTUS" << '\n';
    else
        cout << result << '\n';
}

int main()
{
    getInput();
    solve();
}