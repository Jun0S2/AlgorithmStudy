#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string input;
  cin>>input;
  //설계 : vector만들어서 나온 횟수++,vector<string>해서 합치기
  
  vector<char>letters;
  vector<int>count;
  
  count.push_back(1);
  letters.push_back(input[0]);
  char prev = input[0];
  int index = 0;
  
  for(int i =1; i<input.size() ; i++)
  {
    //한번만 나온 경우가 소리지르는것같음
    if(input[i]!=prev)
    {
      index++;
      prev = input[i];
      letters.push_back(prev);
      count.push_back(0);//더함
    }
    count[index]++;
  }
 // for(auto i :  count)cout<<i<<" ";
 // cout<<endl;
  //cout<<count.size()<<"and"<<letters.size()<<endl;
  for(int i = 0 ; i<letters.size() ; i++)
  {
    if(count[i]!=1)cout<<count[i];
    cout<<letters[i];
  }

  return 0;
}
