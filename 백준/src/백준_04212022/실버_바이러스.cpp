#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

vector<bool> visited;
vector<vector<bool>> vertex;

int N,M;

int bfs(){
    int infected = 0;
    queue<int> q;//큐 생성
    q.push(1);//첫번째 배열
    visited[1] = true;//방문
    
    while(!q.empty()){
      int x = q.front();//현재 방문중인 노드
      q.pop();
      
      for(int i = 1 ; i<=N ; i++)//배열 돌면서 
      {
        if(visited[i])continue;
        if(i==x)continue;//본인
        if(vertex[x][i])//연결
        {
          infected++;
          q.push(i);
          visited[i] = true;//방문 처리
        }
      }
    }
  return infected;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  cin>>N>>M;
  
  vertex.resize(N+1, vector<bool>(N+1,0));
  visited.resize(N+1,false);
  
  int a,b;//vertexes
  for(int i = 0 ; i<M ; i++)
  {
     cin>>a>>b;
     vertex[a][b] = true;
     vertex[b][a] = true;
  }
  
 //for(auto i : vertex){for(auto j : i){cout<<j<<" ";} cout<<endl;}
 cout<<bfs();
  
  return 0;
}

