#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

/**
BFS
04/07/2022
백준문제와 동일
*/
using namespace std;

int N;
vector<vector<int>>map;
vector<int> answer;
vector<int> dx = {-1,1,0,0};
vector<int> dy = {0,0,-1,1};


int bfs(int a, int b, int aptNum){
  //시작점 : 0,0
  vector<vector<bool>>visited(N,vector<bool>(N,false));
  queue<pair<int,int>>q;
  visited[a][b] = true;
  q.push({a,b});
  map[a][b] = aptNum;
  
  int cnt = 1;//1부터 시작이니까
  
  
  while(!q.empty())
  {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    
    for(int d = 0; d<4 ; d++)
    {
      int nx = dx[d] + x;
      int ny = dy[d] + y;
      
      if(nx<0||nx>=N||ny<0||ny>=N)continue;
      if(visited[nx][ny])continue;
      if(map[nx][ny]==0)continue;
      
      //else : 
      else if (map[nx][ny]==1)
      {
        visited[nx][ny] = true;
        map[nx][ny] = aptNum;//2부터 넣기
        q.push({nx,ny});
        cnt++;
      }
    }
  }
  return cnt;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin>>N;
  map.resize(N,vector<int>(N));
  string temp;
  
  for(int i = 0; i<N ; i++)
  {
    cin>>temp;
    for(int j = 0 ; j<N ; j++)
    {
      map[i][j] = temp[j]-'0';
    }
  }
  
  int aptNum =2;
 for(int i = 0 ; i<N ; i++)
 {
   for(int j = 0 ; j< N ; j++)
   {
     if(map[i][j]==1)
     {
       answer.push_back(bfs(i,j,aptNum++));
  
     }
     else continue;
   }
 }
//bfs 결과 확인 : for(auto i : map){for(auto j :i){cout<<j<<" ";}cout<<endl;}


//정렬
sort(answer.begin(), answer.end());
cout<<answer.size()<<endl;
for(auto i : answer)cout<<i<<endl;
 
  return 0;
}
