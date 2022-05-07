#include <iostream>
#include <vector>

using namespace std;

int N,R;
vector<char>alphabets =  {'a', 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','v','w','x','y','z'};
vector<vector<char>>answer;
void dfs( int depth , vector<char>temp , vector<bool>visited ){
  if(depth == R)
  {
    for(auto i : temp)cout<<i;
    cout<<endl;
    return; 
  }
  for(int i = 1 ; i<=N ; i++) //start with 1 
  {
    if(visited[i])continue;
    visited[i] = true;
    temp.push_back(alphabets[i]);
    dfs(depth+1 ,  temp, visited);
    visited[i] = false;
    temp.pop_back();
    // start 다시 빼줘야하나?
    
  }
  
}


int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  //nCr
  cin>>N>>R;
  vector<char>temp;
  vector<bool>visited(N+1);
  dfs(0,temp,visited);
  
  return 0;
}
