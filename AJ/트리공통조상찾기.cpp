#include <iostream>
#include <vector>

using namespace std;


int N;
int v1, v2; //vertex 1 & vertex2
vector<bool> visited;
vector<int> parent;

int main() {

  cin>>N>>v1>>v2;
  //vec.resize(N ,vector<int>(2,0));
  parent.resize(N,0);
  visited.resize(N,false);
  
  int a, b;
  for(int i = 0 ; i<N-1 ; i++)
  {
    cin>>a>>b;
    parent[b]= a;
  }
  
  while(1)
  {
    visited[v1] = true; //방문처리
    if(v1 == 0)break; //끝
    v1 = parent[v1]; // 다음노드탐색
  }
  while(true)
  {
    if(visited[v2]) //찾음
    {
      cout<<v2<<endl;
      return 0;
    }
    else
    {
      visited[v2] = true;//방문처리 
      v2 = parent[v2];
    }
  }
  

  return 0;
}
