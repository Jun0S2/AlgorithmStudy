#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N, M;
vector<vector<int>> board;     // 연구소 상태
vector<vector<int>> simulated; // 시뮬레이션용 복사본
int dx[] = {-1, 1, 0, 0};      // 상, 하, 좌, 우
int dy[] = {0, 0, -1, 1};

// 연구소 상태 복사
void copyBoard()
{
    simulated = board;
}

// 바이러스 확산 (BFS 사용)
void spreadVirus()
{
    queue<pair<int, int>> q;

    // 바이러스가 있는 모든 위치에서 BFS 시작 (이후에 감염된애들도 큐에 넣을거임)
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (simulated[i][j] == 2)
            {
                q.push({i, j});
            }
        }
    }

    // 바이러스 퍼뜨리기
    while (!q.empty()) // q에는 바이러스가 담겨있음
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int d = 0; d < 4; d++)
        {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M)
            {
                if (simulated[nx][ny] == 0)
                { // 빈칸이면 바이러스 퍼짐
                    simulated[nx][ny] = 2;
                    q.push({nx, ny});
                }
            }
        }
    }
}

// 안전 영역 계산
int countSafeArea()
{
    int safe = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (simulated[i][j] == 0)
            { // 빈칸이 안전 지역
                safe++;
            }
        }
    }
    return safe;
}

// 벽을 세우고 바이러스 퍼뜨린 후 안전 영역 계산
int solve()
{
    int maxSafeArea = 0;
    vector<pair<int, int>> emptySpaces; // 빈칸 목록

    // 빈칸 목록 수집
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (board[i][j] == 0)
            {
                emptySpaces.push_back({i, j});
            }
        }
    }
    // emptySpaces  = {{}, {}, {}, {}}
    // comb         = {0 ,  0 , 0, 1}
    // 빈칸 중 3개를 선택하는 모든 조합을 생성
    int emptySize = emptySpaces.size();
    vector<int> comb(emptySize, 0);
    fill(comb.end() - 3, comb.end(), 1); // 3개만 일단 on 시켜봄

    do // 조합으로 comb 섞은 후에, 벽을 세운다
    {
        copyBoard();                        // 연구소 상태 복사
        for (int i = 0; i < emptySize; i++) // 벽 세울 수 있는 공간 중
        {
            if (comb[i] == 1) // 조합에서 세워준 자리
            {
                int x = emptySpaces[i].first; // 해당 자리의 좌표값들
                int y = emptySpaces[i].second;
                simulated[x][y] = 1; // 벽 세우기
            }
        }

        // 벽 다 세웠으니, 바이러스 퍼뜨리기
        spreadVirus();

        // 안전 영역 계산 후 최대값 갱신
        int safeArea = countSafeArea();
        maxSafeArea = max(maxSafeArea, safeArea);

    } while (next_permutation(comb.begin(), comb.end())); // 조합 cheatkey

    return maxSafeArea;
}

int main()
{
    cin >> N >> M;
    board.resize(N, vector<int>(M));

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];
        }
    }

    // 문제 해결 및 결과 출력
    cout << solve() << '\n';
    return 0;
}
