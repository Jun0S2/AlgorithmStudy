#include<iostream>
#include <vector>
using namespace std;
 
int N;
vector<int>D(1000007,0);

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin>>N;
  
  D[0] = 0;
  D[1] = 1;
  D[2] = 2;
  
  for(int i=3; i<=N; i++){
    D[i] = D[i-2] + D[i-1];
    D[i] %= 1000007;
  }
  
  cout<<D[N]<<endl;
  
  return 0;
}
