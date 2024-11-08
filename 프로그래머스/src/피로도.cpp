#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
int maxExplored = 0;
// https://school.programmers.co.kr/learn/courses/30/lessons/87946# 
/** 모든 경우의 수를 구한다.*/
void dfs(int hp, int explored, vector<bool>& visited, vector<vector<int>>& dungeons) {
    // 현재까지 탐험한 던전 수를 업데이트
    maxExplored = max(maxExplored, explored);

    for (int i = 0; i < dungeons.size(); i++) { // 던전 방문
        if (visited[i]) continue; // 이미 방문한 던전은 건너뜀
        if (hp < dungeons[i][0]) continue; // 최소 피로도가 부족한 경우 건너뜀
        // 소모 필요도는 계산할 필요 없네... 최소 피로도가 소모 피로도 보다 높으니
        
        // 던전을 탐험
        visited[i] = true;
        dfs(hp - dungeons[i][1], explored + 1, visited, dungeons);
        visited[i] = false; // 백트래킹: 탐험 후 다시 방문하지 않은 상태로 되돌림
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = 0; // count
    int hp = k;
    vector<bool> visited(dungeons.size(),false);
    dfs(hp,0, visited, dungeons);
    
    return maxExplored;
}
