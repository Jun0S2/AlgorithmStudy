#include<vector>
#include <array>
#include <queue>
using namespace std;
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

bool visited[100][100];
vector<vector<int>> board;
int N;
int M;

int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,1,-1};

// bfs 최소거리
int bfs() {
    queue<pair<int,int>> q;
    q.push({0,0});
    visited[0][0] = true;

    vector<vector<int>> distance(N, vector<int>(M, 0));
    distance[0][0] = 1; // 시작 지점의 거리는 1
    
    while(!q.empty()) {
        int x =q.front().first;
        int y =q.front().second;
        q.pop();
        if (x == N-1 && y == M-1) {
            return distance[x][y];
        }
        for (int d = 0 ; d < 4; d++) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx <0 || ny <0 || nx>= N || ny >=M ) continue;
            if (visited[nx][ny]) continue;
            if (board[nx][ny]==0)continue; // 벽
            // else 
            visited[nx][ny] = true;
            q.push({nx,ny});
            distance[nx][ny] = distance[x][y]+1;
        }
    }
    return -1;
}
int solution(vector<vector<int>> maps)
{
    int answer = 0;
    N = maps.size();    // 세로 크기
    M = maps[0].size(); // 가로 크기

    board = maps;
    answer = bfs();
    return answer;
}
