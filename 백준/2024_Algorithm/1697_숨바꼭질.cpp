/**
 * 수빈이 동생 가장 빨리 찾는 경우
 * 순간이동 : 좌표 *2
 * 일반 이동 : 좌표 +-1
 * 일직선상이라는거...
 * https://www.acmicpc.net/problem/1697
 * Silver 1
 */
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N, K;                            // 0 <= N, K <= 100,000
vector<bool> visited(100001, false); // Size should be enough for N and K

int bfs()
{
    queue<int> q;
    q.push(N);
    visited[N] = true;
    int time = 0;

    while (!q.empty())
    {
        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            int current = q.front();
            q.pop();

            if (current == K) // 동생 위치
            {
                return time; // bfs 는 항상 먼저 찾는게 가장 빠른거
            }

            int nextPositions[] = {current - 1, current + 1, current * 2};

            for (int next : nextPositions)
            {
                if (next >= 0 && next <= 100000 && !visited[next]) // 범위 ok && 방문 안한곳
                {
                    visited[next] = true;
                    q.push(next);
                }
            }
        }
        time++; // 좋던 말던 시간은 흐름
    }
    return -1;
}

int main()
{
    cin >> N >> K; // 수빈이와 동생의 위치
    int result = bfs();
    cout << result << '\n';
    return 0;
}
