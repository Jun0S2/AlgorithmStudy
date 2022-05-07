/**
* 4/26/2022
* DP
*/

#include<iostream>
#include <vector>

using namespace std;
 
int N;
vector<int>D(100005,0);
 
int main(){
  
  cin>>N;
  
  D[0] = 0;
  D[1] = 1;
  D[2] = 2;
  D[3] = 4;
  
  long long sum;
  
  for(int i=4; i<=N; i++){
    sum = D[i-3] + D[i-2] + D[i-1];
    sum %= 1000007;
    D[i] = sum;
  }
  
  cout<<D[N];
  
  
  return 0;
}
