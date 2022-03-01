#include <iostream>
#include <vector>

using namespace std;

vector<int> d(21,0);//피보나치 수열을 담을 벡터

void fibo(){
  d[0] = 0;
  d[1] = 1;
  d[2] = 1;
  for(int i = 3 ;i<=20 ; i++)
  {
      d[i] = d[i-1] + d[i-2];
  }
}

int main(){
   fibo();
   int N;
   cin>>N;
   cout<<d[N]<<endl;
   
}