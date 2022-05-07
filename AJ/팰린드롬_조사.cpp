#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string input;
  cin>>input;
  //홀수면 가운데 글자 빼고 체크
  int mid = input.size()/2;
  if(input.size()%2!=0) input.erase(input.begin()+mid);
  //cout<<input;
  
  int index = 1;
  
  for(int i = 1; i< input.size()/2 ; i++)
  {
    //cout<<input[mid+i-1]<<" and "<<input[mid-i]<<endl;
    if(input[mid+i-1]!=input[mid-i]) {cout<<"NO";return 0;}
  }
  cout<<"YES";
  return 0;
}
