#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>>board(5,vector<int>(5,0));
int answer = 0;

void print(){
   for(int i = 0 ; i<5 ; i++)
  {
    for(int j = 0 ; j<5 ; j++)
    {
     cout<<board[i][j]<<" ";
    }
    cout<<endl;
  }
  cout<<"=========================="<<endl;
}
void check(int num){
  for(int i = 0 ; i<5 ; i++)
  {
    for(int j = 0 ; j<5 ; j++)
    {
     if(num==board[i][j])
     {
       board[i][j] = 0;
       return;
     }
    }
  }
}

void vertHor(){
  
  for(int i = 0 ; i<5 ; i++)
  {
    int vCnt = 0;
    int hCnt =0;
    for(int j = 0 ; j<5 ; j++)
    {
      if(board[i][j]==0)vCnt++;
      if(board[j][i]==0)hCnt++;
    }
    if(vCnt ==5 )answer++;
    if(hCnt==5)answer++;
  }
}

void dia(){
  int rCnt = 0;
  int lCnt = 0;
  
  for(int i = 0 ; i< 5 ; i++)
  {
    if(board[i][i]==0)rCnt++;
    if(board[4-i][i]==0)lCnt++;

  }
  if(rCnt ==5)answer++;
  if(lCnt == 5)answer++;

}
int main() {
  
  for(int i = 0 ; i<5 ; i++)
  {
    for(int j = 0 ; j<5 ; j++)
    {
      cin>>board[i][j];
    }
  }
  
  int input = 0;
  
  for(int i = 1 ; i<=25 ; i++)
  {
    cin>>input;
    answer = 0;//초기화
    check(input);
   
  vertHor();
  dia();
  if(answer>=3){cout<<i<<endl;return 0;}
  }


  return 0;
}
