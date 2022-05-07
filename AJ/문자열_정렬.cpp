#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N;  
  cin>>N;
  vector<string>input(N,"");
  for(int i =0 ; i<N ; i++)cin>>input[i];
  sort(input.begin(),input.end());
  for(auto i :  input)cout<<i<<endl;
  return 0;
}
