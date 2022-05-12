#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<int, int> m;

int main() {

  int N,Q;
  cin>>N>>Q;
  
  int key = 0;
  
  for(int i = 0 ; i<N ; i++)
  {
    cin>>key;
    m[key]++;
  }
  
  // for(auto i : m)
  // {
  //   cout<<i.first<<" : "<<i.second<<endl;
  // }

  int find = 0;
  for(int q = 0 ; q<Q ; q++)
  {
    cin>>find;
    cout<<m[find]<<endl;
  }
  return 0;
}
