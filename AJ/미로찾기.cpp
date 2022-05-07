#include <iostream>
#include <vector>
#include <queue>

/**
4/07/2022
BFS
*/
using namespace std;

int N, M ;
vector<vector<int>>map;

//interface 같은거
struct Node {
  int x;
  int y;
  int dist;
};


vector <int>  dx = {-1,1,0,0};
vector <int>  dy = {0,0,-1,1};
int minDistance = 2147483627;

void bfs( ){
  queue<Node> q;
  q.push({N-1,0 ,0});//출발 거리 
  vector<vector<bool>>visited (N,vector<bool>(M,false));
  visited[N-1][0] = true;
  
  while(!q.empty())
  {
    Node node = q.front();
    int x = node.x;
    int y = node.y;
    int dis = node.dist;
    q.pop();
  //  cout<<x<<" "<<y<<endl;
    
    if(x==0 && y == M-1 ) //도착 
    {
     // cout<<"도착 \n";
      minDistance = dis<minDistance?dis:minDistance;
      return;
    }
  
    for(int d= 0 ; d<4 ;d++)
    {
      
      int nx = dx[d] + x;
      int ny = dy[d] + y;
      
      if(nx<0||ny<0||nx>=N||ny>=M)continue;
      if(visited[nx][ny])continue;
      if(map[nx][ny]==1)continue;

      visited[nx][ny] = true;
      q.push({nx,ny, dis+1});
 //   cout<<"nx: "<<nx<<" ny: "<<ny<<endl;
    }
  }

}

int main() {
  cin>>N>>M;
  map.resize(N,vector<int>(M,0));
  for(int i = 0 ; i<N ; i++)
  {
    for(int j = 0; j<M; j++)
    {
      cin>>map[i][j];
    }
  }
  
  bfs();
  cout<<minDistance<<endl;

  return 0;
}
