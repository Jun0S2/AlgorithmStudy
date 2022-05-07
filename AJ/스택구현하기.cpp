#include <iostream>
#include <vector>
using namespace std;


int N, M;

int main() {
  cin>>N>>M; //스택의 크기, 연산의 개수
  vector<int>stack;
  
  
  int command = 0, op = 0;
  //1 : push, 2 : pop , 3:top 
  for(int m = 0 ; m<M ; m++)
  {
       cin>>command;
       if(command == 1 )
       {
         cin>>op;
         if(stack.size()>=N)cout<<"Overflow"<<endl;
         else { stack.push_back(op);}
       }
       
       else if (command == 2)
       {
         if(stack.empty())cout<<"Underflow"<<endl;
         else stack.pop_back();
       }
       else
       {
         if(stack.empty())cout<<"NULL"<<endl;
         else cout<<stack[stack.size()-1]<<endl;
       }
     
  }
  return 0;
}
