#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N,S;

int main() {
  cin>>N >> S;//N줄,S가 시작 숫자임
  
//규칙 : i*2 +1 개만큼 프린트하고
//공백은 i~mid까지 한다

  int mid = N/2;
  for(int i = 0;i<N ; i++)
  {
   //공백
   for(int j = i; j < N-1 ; j++)
   {
     cout<<" "; 
   }
      if(i%2==0){
      vector<char>temp;
      for(int j = 0 ; j< i*2+1 ; j++)
      {
        temp.push_back(S+'0');
        S++;
        if(S==10)S=1;
      }
      for(int j = temp.size()-1 ; j>=0; j--)
      {cout<<temp[j];}
    }
    else
    {
      for(int j = i*2 ; j>=0 ; j--)
      {
        cout<<S;
         S++;
         if(S==10)S=1;
      }
    }
    cout<<endl;
  }
 

  return 0;
}
