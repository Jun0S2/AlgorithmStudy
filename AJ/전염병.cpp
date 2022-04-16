#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N,K;

int bfs(int start){//start는 K 
  queue<int>q;
  vector<bool>visited(N+1,0);
  q.push(start);
  
  while(!q.empty())
  {
    int town = q.front();
    q.pop();
    
    if(!visited[town]){ //중복 피하기
      q.push(town/3);
      
      if(town*2<=N) 
      { 
        q.push(town*2);
      }
      visited[town] = true;
    }
  }
  
  int cnt = 0;
  for(int i = 1; i<=N ; i++)
  {
    if(!visited[i]) cnt++;
  }
  return cnt;
}

int main() {

  cin>>N>>K;
  cout<<bfs(K);
  
  return 0;
}
