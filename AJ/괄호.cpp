/**
stack 문제지만, counter로 푸는게 더 효율적
4/12/2022
*/
#include <iostream>
#include <vector>

using namespace std;

int main() {
  string input;
  cin>>input;
  vector<char>p(input.size());
  
  for(int i = 0 ; i<input.size() ; i ++)
  {
      p[i] = input[i];
  }
  
  //validate
  int openP = 0;

  for(int i = 0 ; i<input.size() ; i++ )
  {
    if(p[i]=='(')openP++;
    else openP--;
    if(openP<0){cout<<"NO";return 0;}
  }
  if(openP==0) cout<<"YES";
  else cout<<"NO";
  return 0;
}
