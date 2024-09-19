#include <iostream>
#include <vector>
#include <queue>
/**
 * 엄청난 깨달음... 바이러스 문제에 큐 에 감명받아서 그랬나 .. 복잡하게 생각했음
 * 적의 위치를 구지 파악하지 않아도괜찮음.
 * 모든 배열을 탐색해서, 얘가 움직일 수 있는 dx,dy 가 있음.
 * 맨 마지막에 적의 위치가 어디에 있었는지만 표현하면 됌
 */
using namespace std;

int N;                          // 체스판 크기
int M;                          // 적 수
vector<pair<int, int>> enemies; // 적 위치
vector<vector<int>> board;      // 각 위치까지의 거리
vector<vector<bool>> visited;
int currX, currY; // 나이트의 현재 위치

// 나이트의 움직임
int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

void solve()
{
    visited.assign(N + 1, vector<bool>(N + 1, false));
    board.assign(N + 1, vector<int>(N + 1, 0));

    queue<pair<int, int>> q;
    q.push({currX, currY});
    visited[currX][currY] = true;
    board[currX][currY] = 0;

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            board[nx][ny] = board[x][y] + 1;
            q.push({nx, ny});
        }
    }
}

void getInput()
{
    cin >> N >> M >> currX >> currY;
    enemies.resize(M);
    for (int i = 0; i < M; i++)
    {
        cin >> enemies[i].first >> enemies[i].second;
    }
}

int main()
{
    getInput();
    solve();

    for (const auto &enemy : enemies)
    {
        // 각 적 위치까지의 최소 이동 거리 출력
        cout << board[enemy.first][enemy.second] << " ";
    }
    cout << "\n";

    return 0;
}

/*
적들의 좌표 입력: 적들의 좌표를 입력받을 때 enemies.resize(M)으로 크기를 이미 설정했으므로 push_back으로 추가할 필요가 없습니다.
 대신 인덱스를 통해 값을 할당하면 됩니다.
적을 찾는 방식: copytEnemies에서 적을 찾을 때 erase로 삭제하는 것은 시간 복잡도가 높습니다.
적을 삭제하는 대신, 적이 있는 좌표에 도착했는지만 확인하고 그 상태를 유지하는 것이 더 효율적입니다.
최소 이동을 계산하는 BFS 구조: BFS 탐색에서 각 적에 대해 최소 이동 거리를 계산하고,
이를 출력해야 합니다. 탐색은 나이트가 적을 찾아가는 모든 경로에서 거리를 기록하는 방식으로 해결됩니다.
불필요한 복사 제거: copytEnemies는 없어도 괜찮습니다.
나이트가 적을 만나면 바로 해당 위치의 board 값을 출력하면 됩니다.

int N; // size
int M; // enemies
vector<pair<int, int>> enemies;
vector<vector<int>> board; // distance
vector<vector<bool>> visited;
int currX, currY;
int ans = 0xffff; // 최소 이동

int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

void solve()
{
    visited.assign(N + 1, vector<bool>(N, false));
    queue<pair<int, int>> q;
    vector<pair<int, int>> copytEnemies = enemies;
    q.push({currX, currY});
    visited[currX][currY] = true;
    board[currX][currY] = 0;

    int killcount = 0;

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < M; i++)
        {
            if (copytEnemies[i].first == x && copytEnemies[i].second == y)
            { // 찾으면 삭제
                killcount++;
                copytEnemies.erase(copytEnemies.begin() + i);
            }
        }

        if (killcount == 3) // 모든 적을 다 죽임
        {
            break;
        }

        for (int i = 0; i < 8; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            board[nx][ny] = board[x][y] + 1;
            q.push({nx, ny});
        }
    }
}
void getInput()
{
    cin >> N >> M >> currX >> currY;
    board.assign(N, vector<int>(N + 1, 0));
    enemies.resize(M);
    for (int i = 1; i <= M; i++)
    {
        int x, y;
        cin >> x >> y;
        enemies.push_back({x, y});
    }
}

int main()
{
    getInput();
    solve();
    for (auto x : enemies)
    {
        cout << board[x.first][x.second] << " ";
    }
    return 0;
}
*/