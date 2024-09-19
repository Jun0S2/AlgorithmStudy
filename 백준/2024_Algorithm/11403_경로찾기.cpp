/**
 * @date 2024.09.19
 * @author June Park
 * Silver 1
 * https://www.acmicpc.net/problem/11403
 * FloydWarshall
 *
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
const int MAX = 100;
int N; // 정점의 개수
vector<vector<int>> graph;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

// 플로이드-워셜 알고리즘
// 모든 정점 쌍 간의 최단 경로를 찾는 알고리즘
// 위 문제에서는 경로 존재만 확인해도 되서 사용 가능
// 간접적인 경로도 찾아낼 수 있음
// 세 개의 반복문을 사용해 모든 경유지(k), 출발지(i), **목적지(j)**에 대해 경로를 업데이트합니다.
void floydWarshall()
{
    // 모든 경유지 k 에 대해
    for (int k = 0; k < N; k++)
    {
        // 모든 출발지 start 에 대해
        for (int start = 0; start < N; start++)
        {
            // 모든 목적지 end 에 대해
            for (int end = 0; end < N; end++)
            {
                // start 에서 end 로 직접 갈수 없지만 (경유지끼리만 갈 수 있으면 되네)
                // start에서 경유지k를 걸쳐 end 로 갈 수 있는 경우 경로를 표시
                if (graph[start][k] && graph[k][end])
                {
                    graph[start][end] = 1;
                }
            }
        }
    }
}
int main()
{
    cin >> N;
    graph.assign(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> graph[i][j];
        }
    }
    floydWarshall();
    // 결과 출력
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cout << graph[i][j] << " ";
        }
        cout << '\n';
    }
}