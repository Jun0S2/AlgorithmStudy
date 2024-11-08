#include<vector>
#include <array>
#include <queue>
#include <iostream>
using namespace std;
// https://school.programmers.co.kr/learn/courses/30/lessons/1844 
// 사방탐색
vector<int> dx = {-1,1,0,0};
vector<int> dy = {0,0,-1,1};
int N = 0; int M = 0;
// 최소는 무조건 bfs
int bfs (vector<vector<int>> & visited, vector<vector<int>> &map) {
    queue<pair<int,int>> q;
    q.push({0,0});
    visited[0][0] = 1; // 거리
    
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        
        for (int d = 0 ; d< 4; d++) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (nx<0|| nx >=N|| ny <0 || ny>=M) continue;
            if (visited[nx][ny] != -1) continue; // 이미 방문 한곳임.
            if (map[nx][ny]==0) continue;
            // first time visiting
            visited[nx][ny] = visited[x][y] +1;
            // cout << "map : " << map[nx][ny] << " nx : " << nx << " ny " << ny << " distance : " << visited[nx][ny] << endl;
            q.push({nx,ny});
        }
    }
    return visited[N-1][M-1];
}
int solution(vector<vector<int>> maps)
{   
    N = maps.size();
    M = maps[0].size(); // 아놩
    vector<vector<int>> visited(N, vector<int>(M,-1));
    int answer = bfs(visited,maps);

    return answer;
}
