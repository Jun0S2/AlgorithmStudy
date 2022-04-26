#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> D;
/* 
D[N] = 숫자 N을 제곱수로 나타내는 최소 항의 개수 
D[N] = min (D[N-i2] + 1 or 1)
*/
int main() {
  cin>>N;
  D.resize(N+1,0);
  
  for(int i = 1 ; i<= N ; i++)
  {
    D[i] = i;
    for(int j = 1 ; j*j<=i ; j++)
    {
      if(D[i]>D[i-j*j] +1 )D[i] = D[i-j*j]+1;
    }
    
  }
  cout<<D[N];


  return 0;
}
