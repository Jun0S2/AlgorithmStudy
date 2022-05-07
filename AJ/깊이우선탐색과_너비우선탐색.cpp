#include <iostream>
#include <vector>
#include <queue>

/**
05/07/2022
백준과 유사한 문제
*/
using namespace std;

int N,M; //정점의 개수 간선의 개수
vector<vector<bool>>v;
vector<bool>visited_DFS;
vector<bool>visited_BFS;

/* dfs */
void dfs(int v1)
{
  visited_DFS[v1] = true;//방문처리
  cout<<v1<<" ";
  
  for(int i = 1 ; i<=N ; i++)
  {
    if(visited_DFS[i])continue; //이미 방문
    if(!v[v1][i])continue;//연결 x 
    dfs(i); //else
  }
}

/* bfs */
void bfs (int v2)
{
  queue<int>q;
  visited_BFS[v2] = true;
  q.push(v2);
  cout<<v2<<" ";
  
  while(!q.empty())
  {
    int node = q.front();
    q.pop();
    
    for(int i = 1; i<=N ; i++)
    {
      if(visited_BFS[i])continue;//이미 방문
      if(!v[node][i]) continue;//연결 x
      
      //else
      q.push(i);
      visited_BFS[i] = true;
      cout<<i<<" ";
    }
    
  }
}

int main() {
  cin>>N>>M;
  
  v.resize(N+1, vector<bool>(N+1));
  visited_BFS.resize(N+1);
  visited_DFS.resize(N+1);
  
  //M개의 간선 받기
  int x,y;
  for(int m = 1; m<=M ; m++)
  {
    cin>>x>>y;
    v[x][y] = v[y][x] = true;
  }
  
  dfs(0);//0번을 정점으로 시작
  cout<<endl;
  bfs(0); //0번을 정점으로 시작
  return 0;
}
