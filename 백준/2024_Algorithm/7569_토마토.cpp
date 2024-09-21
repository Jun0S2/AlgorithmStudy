/**
 * https://www.acmicpc.net/problem/7569
 * 3d map
 * gold 5
 */
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int M, N, H;            // 가로, 세로, 개수
int box[101][101][101]; // -1 빈칸 1 익 0 안익
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int dz[] = {1, -1};
int dist[101][101][101];

class Tomato
{
public:
    int h; // height
    int x; // x 좌표
    int y; // y 좌표
    Tomato(int h, int x, int y) : h(h), x(x), y(y) {}
};

queue<Tomato> tomatos;

void getInput()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> M >> N >> H;
    for (int h = 0; h < H; h++)
    {
        for (int n = 0; n < N; n++)
        {
            for (int m = 0; m < M; m++)
            {
                cin >> box[h][n][m];
                if (box[h][n][m] == 1)
                {
                    // 익은 토마토들은 전부 삽입!
                    tomatos.push(Tomato(h, n, m));
                    dist[h][n][m] = 0;
                }
                else if (box[h][n][m] == 0) // 헐..
                {
                    dist[h][n][m] = -1; // 아직 익지 않은 토마토는 거리 -1로 초기화
                }
            }
        }
    }
}

bool available(int k, int nx, int ny)
{
    if (nx < 0 || nx >= N || ny < 0 || ny >= M || k < 0 || k >= H)
        return false;
    if (box[k][nx][ny] != 0) // 안익은 토마토만 찾는중
        return false;
    return true;
}

int count()
{
    int maxDays = 0;
    for (int h = 0; h < H; h++)
    {
        for (int n = 0; n < N; n++)
        {
            for (int m = 0; m < M; m++)
            {
                // fail scenarios
                if (box[h][n][m] == 0)
                    return -1;
                maxDays = max(maxDays, dist[h][n][m]);
            }
        }
    }

    return maxDays;
}

void bfs()
{
    while (!tomatos.empty())
    {
        int x = tomatos.front().x;
        int y = tomatos.front().y;
        int k = tomatos.front().h;
        tomatos.pop();

        for (int d = 0; d < 4; d++)
        {
            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if (available(k, nx, ny))
            {
                box[k][nx][ny] = 1;
                tomatos.push(Tomato(k, nx, ny));
                dist[k][nx][ny] = dist[k][x][y] + 1;
            }
        }
        // 앞뒤
        for (int d = 0; d < 2; d++)
        {
            int nz = dz[d] + k;
            if (available(nz, x, y))
            {
                box[nz][x][y] = 1;
                tomatos.push(Tomato(nz, x, y));
                dist[nz][x][y] = dist[k][x][y] + 1;
            }
        }
    }
}

int main()
{
    getInput();
    bfs();
    cout << count() << "\n";
    return 0;
}