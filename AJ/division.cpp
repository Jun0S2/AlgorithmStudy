#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int cnt=0;
vector<int>answer;

void division(int n, int index, int totalSum ){
  if(totalSum == n)
  {
    cout<<answer.front();
    for(int i = 1; i<index ; i++)
    {
      cout<<"+"<<answer[i];
    }
    cnt++;
    cout<<endl;
  }
  //else
  int sum = 0;
  if(index ==0 )sum = n-1; //첫 숫자
  else sum = n - totalSum ; // whole num - curr sum 
  
  for(int i = sum ; i> 0 ; i--)
  {
    answer[index] = i;
    if(index > 0 && answer[index] > answer[index-1])continue;
    division(n,index+1 , totalSum +i );
  }
  
  
}

int main() {
  int n;
  cin>>n;
  answer.assign(n,0);
  division(n,0,0);

  cout<<cnt;
  return 0;
}
