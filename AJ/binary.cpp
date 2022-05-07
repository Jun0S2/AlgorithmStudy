#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int>bin;

void toBinary(int n){
  while(n>1)
  {
    bin.push_back(n%2);
    n/=2;
  }
  bin.push_back(n);
}
int main() {

  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin>>N;
  toBinary(N);
  for(int i = bin.size()-1 ; i>=0 ; i--)
  {
    cout<<bin[i];
  }
  return 0;
}
