#include <vector>
#include <iostream>

using namespace std;

int main() {

  int N;
  cin>>N;
  vector<vector<int>>students (N,vector<int>(6,0));
  
  
  for(int i = 0 ; i< N ; i++)
  {
    for(int j = 0 ; j< 5 ; j++)
    {
      cin>>students[i][j];
    }
  }
  
  //for(auto i : students ){for(auto j :i){cout<<j<<" ";}cout<<endl;}
  
  //vector<vector<bool>>same(N,vector<bool>(N,false));//visit 배열 안필요한거 아니야..?으엑 다시생각..
  //아 이거 학년이 겉에오면 안되고 안에 들어갔던ㄷ것같은데
  
  int max = -1;
  int student = 0;
  
  //학년이랑 학생을 바꿔야하나...
  
  for(int i = 0; i<N; i++)//학생
  {
    int cnt = 0;
    for(int j = 0 ; j<N ; j++)//다른 학생도.. 헐 j인데 i 로..햇엇다
    {
      if(i==j)continue;
      for(int k=0; k<5 ; k++)//학년
      {
       if(students[i][k]  == students[j][k])
       {
          //cout<<i+1<<"와  "<<j+1<<" 는 "<<k<<"학년 때 같은반"<<endl;
         cnt++;
         break;
       }
      }//end of 학년
      
    }//end of student
    if(max<cnt)
   {
     max = cnt;
     student = i+1;
   }
  }//end 
  
cout<<student;



  return 0;
}
