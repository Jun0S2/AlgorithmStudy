#include <iostream>
#include <vector>
#include <cstring>
/**
Graph
4/07/2022
*/
//문제가 그냥 이분그래프인지 물어본ㅁ
using namespace std;

const int MAX = 20001;
vector<int>vertex[MAX]; //각 vertex(연결된 애들)리스트
int color[MAX];
int N,M;

void dfs(int index , int col){
  color[index] = col;//현재 색상
  for(int i = 0 ; i<vertex[index].size(); i++)//index에 담긴 모든 vertex 확인
  {
     int x = vertex[index][i];
     if(color[x]==0)
     {
       dfs(x, 3 - col);
     }
  }
}
bool isBigraph(){
  for(int i = 1; i<=N; i++)
  {
    for(int j = 0 ; j<vertex[i].size() ; j++)
    {
      int x = vertex[i][j];//다음 색상 
      if(color[i]==color[x])return false;//색이 같은 경우 이분 그래프가 아님
    }
  }
  return true;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  cin>>N>>M;
  memset(color, 0, sizeof(color));
  for(int i = 0 ; i<MAX ; i++)vertex[i].clear();
  
  int a,b;//vertexes
  for(int i = 0 ; i<M ; i++)
  {
     cin>>a>>b;
     vertex[a].push_back(b);
     vertex[b].push_back(a);
  }
  
  for(int i = 1 ; i<N ; i++  )
  {
    if(color[i]==0)
    {
      dfs(i,1);
    }
  }
  
  if(isBigraph())  cout<<"YES";
  else cout<<"NO";
  return 0;
}


