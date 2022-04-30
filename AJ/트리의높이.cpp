#include <iostream>
#include <vector>

using namespace std;

int N;//노드 
vector<vector<int>>tree;
vector<int> visited; //높이 저장


void dfs(int v, int height)
{
  visited[v] = height;
  for(int i = 0 ; i<tree[v].size() ; i++)
  {
    int w =  tree[v][i];
    if(visited[w]==-1)dfs(w,height+1);
  }
}

int main(){
  
  int R;//루트
  
  cin>> N>>R;
  tree.resize(N);
  visited.resize(N, -1); //초기 높이 : -1
  
  int a,b;
  for(int i = 0 ; i<N-1 ; i++)
  {
    cin>>a>>b;
    tree[a].push_back(b);
    tree[b].push_back(a);
  }
  
  // for(int i = 0 ;i<N ; i++)
  // {
  //   cout<<i<<"번째 : ";
  //   for(int j = 0 ; j<tree[i].size(); j++)
  //   {
  //     cout<<tree[i][j]<<" ";
  //   }
  //   cout<<endl;
  // }
  
  dfs(R, 0);
  
  int max = -987654;
  //find max height
  for(int i = 0 ; i<N ; i++)
  {
   max = visited[i] > max ? visited[i] : max;   
  }
  cout<<max;
}
