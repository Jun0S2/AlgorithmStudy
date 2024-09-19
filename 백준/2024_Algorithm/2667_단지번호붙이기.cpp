/**
 * @date 2024.09.19
 * @author June Park
 * Silver 1
 * BFS DFS
 */
#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm> // sort 함수 사용을 위해

using namespace std;

int N; // 5 ~25
vector<vector<int>> board;
vector<vector<bool>> visited; // 방문했는가
vector<int> apartments;       // 아파트 단지 크기 저장
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, 1, -1};

/**
 * Uility function
 */
void printAnswer()
{
    sort(apartments.begin(), apartments.end()); // 크기순 정렬
    cout << apartments.size() << '\n';          // 단지 개수 출력
    for (int x : apartments)
    {
        cout << x << '\n'; // 각 단지 크기 출력
    }
}

/**
 * BFS function to find each apartment complex
 */
void bfs(int startX, int startY)
{
    queue<pair<int, int>> q;
    q.push({startX, startY});
    visited[startX][startY] = true;

    int apartmentCount = 1; // 시작점 자체가 하나의 아파트이므로 1로 시작 (허걱)

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int d = 0; d < 4; d++)
        { // 4방 탐색
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 밖이거나 이미 방문했거나 아파트가 아닌 경우 건너뛰기
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (visited[nx][ny])
                continue;
            if (board[nx][ny] == 0)
                continue;

            visited[nx][ny] = true;
            q.push({nx, ny});
            apartmentCount++; // 같은 단지 내 아파트 수 증가
        }
    }

    apartments.push_back(apartmentCount); // 단지 크기 저장
}

/**
 * count 가 복사되면 독립적인 값으로 동작하게 되어 참조로 넣어야함
 */
void dfs(int x, int y, int &count)
{
    visited[x][y] = true; // 방문 표시
    count++;              // 단지 내 아파트 개수 증가
    // recursive
    for (int d = 0; d < 4; d++)
    {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
            continue;
        if (visited[nx][ny])
            continue;
        if (board[nx][ny] == 0)
            continue;
        visited[nx][ny] = true;
        dfs(nx, ny, count);
    }
    // 탐색이 완료되지 않은 시점에서 잘못된 크기가 저장될 수 있기 때문에 밖에서 count 증가해야함
    // apartments.push_back(count); // 단지 크기 저장
}

void getInput()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    board.resize(N, vector<int>(N, 0));
    visited.resize(N, vector<bool>(N, false));
    string line;
    for (int i = 0; i < N; i++)
    {
        cin >> line;
        for (int j = 0; j < N; j++)
        {
            board[i][j] = line[j] - '0';
        }
    }
}

int main()
{
    getInput();

    // 모든 좌표에 대해 BFS 수행
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (board[i][j] == 1 && !visited[i][j])
            { // 아파트가 있고 아직 방문하지 않았으면 BFS 시작
                // bfs(i, j);
                int cnt = 0;
                dfs(i, j, cnt);
                apartments.push_back(cnt); // 단지 크기 저장
            }
        }
    }

    printAnswer();
}
