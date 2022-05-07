#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string A,B,temp;
  cin>>A>>B;
  if(A.size()<B.size()){temp = A; A=B;B=A;}
  if(A.find(B)!=-1)cout<<"YES";
  else cout<<"NO";
  
  return 0;
}
