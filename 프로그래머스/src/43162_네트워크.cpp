#include <string>
#include <vector>
//https://school.programmers.co.kr/learn/courses/30/lessons/43162
using namespace std;
// n : 컴퓨터 개수, computers : 정보
// 네트워크란 ? 이어진 간선의 개수 + 남은 
int N;
vector<vector<int>> vec;
vector<bool>visited;

void dfs(int node) {
    visited[node] = true;

    for(int i = 0; i < N; i++) { // iterate all nodes
        if (visited[i]) continue; // if done cont
        if(vec[node][i] !=1) continue; // 지금 연결되지 않음
            dfs(i);
    }
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    N = n;
    vec = computers;
    visited.resize(n,false);
    for (int i = 0 ; i< n ; i++){
        if (!visited[i]) {
            dfs(i); // 각 노드별로 연결   -> 신규 네트워크 발견
            answer++; // 네트워크 수 증가
        }
    }
    return answer;
}
