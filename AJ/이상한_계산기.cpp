#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int>v(1000000,0);
int n;

void bfs(){
  queue<int>q;
  q.push(1);
  v[1] = 1;
  
  while(!q.empty())
  {
    int node = q.front();
    q.pop();
    int mul = node * 2;
    int div = (int) node/3;
    //cout<<div<<" ";
    
    if(mul > 0 && mul <= 99999)
    {
      if(v[mul] == 0)
      {
        v[mul] = v[node] + 1;
        q.push(mul);
      }
      else
      {
        v[mul] = (v[mul] < (v[node]+1) ) ? v[mul] : (v[node]+1);
      }
      if(mul ==n )break;
    }
    if(div>0 && div<= 99999)
    {
      if(v[div] == 0 )
      {
        v[div] = v[node]+1;
        q.push(div);
      }
      else
      {
        v[div] = (v[div] < (v[node]+1) ) ? v[div] : (v[node]+1);
      }
      if(div ==n )break;
    }
  }
}


int main() {
  cin>>n;
  bfs();
  cout<<v[n]-1<<endl;
  return 0;
}
