#include <iostream>
#include <vector>
#include <queue>
/**
Bruteforce문제였으나 bfs로 
*/
using namespace std;

  int N;//맵의 크기
  int X,Y,R;//좌표와 사거리
  vector<vector<bool>>visited;
  vector<vector<int>>map;
  vector<int> dx = {-1,1,0,0};
  vector<int> dy = {0,0,-1,1};
  
 void bfs(){
//   //초기 설정
  queue<pair<int,int>>q;
  q.push(pair<int,int>(X,Y));//첫 좌표 
  visited[X][Y] = true;//방문처리
  
  //어째튼 거리는 항상 X,Y 에서 개산하는것
  while(!q.empty())
  {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();

    for(int d = 0 ; d<4 ; d++)
    {
      int nx = x +dx[d];
      int ny = y + dy[d];
      

      if(nx < 0 ||nx>=N || ny<0 || ny>=N)continue;
      if(visited[nx][ny])continue;
      //거리 확인 : 이전꺼에서 1 더하면 되는데
      int dist = map[x][y] + 1 ;
    //  cout<<"distance : "<<dist<<endl;
      if(dist<=R) 
      {
      //  cout<<"dist is less than distance"<<endl;
        map[nx][ny] = dist;
     //   cout<<map[nx][ny]<<endl;
        q.push({nx,ny});
      }
      visited[nx][ny] = true;//방문처리
    }
 }
  
}

void init()
{
    map.resize(N,vector<int>(N,0));
    visited.resize(N,vector<bool>(N,0));
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin>>N>>X>>Y>>R;
  
  init();
  X--; Y--;
  map[X][Y] = 0;
  
 //그냥 bfs 나 dfs 돌려야 할 것 같다
  bfs();
  
  for(int i = 0 ; i<N; i++)
  {
    for(int j = 0 ; j<N ; j ++)
    {
      if(i==X && j==Y) cout << "x ";
      else cout<<map[i][j]<<" ";
    }
    cout<<endl;
  }

  
  return 0;
}
//8
//4 5 3
