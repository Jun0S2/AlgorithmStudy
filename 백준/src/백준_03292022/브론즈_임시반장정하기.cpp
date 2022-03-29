#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  int N ;
  cin>>N;//학생 수 
  vector<vector<int>> students (N+1,vector<int>(6,0));
  
  //get input
  for(int i = 1 ; i<=N ; i++)
  {
    for(int j =1; j<=5; j ++) //총 5학년
    {
      cin>>students[i][j];
    }
  }

  //정답 변수
  int maxCount = 0;
  int president = 0;
  
  
  for(int i = 1 ; i<=N ; i++) //for all students
  {
    int count = 0;
    for(int j = 1; j<= N ; j++) //for other students
    {
      if(i==j) continue;//본인인 경우 
      for(int k = 1; k<=5 ; k++)//반(학년별)
      {
        if(students[i][k] == students[j][k])
        {
          count++;
          break;//더이상 j 친구 신경 안써도 됨!! 
        }
      }
    }
    //max 갱신 : 같은 경우 가장 작은 번호 출력 => 업데이트 x 
    if(maxCount < count)
    {
      maxCount = count;
      president = i;
    }
  }
  //모두 다 같은 반을 해본 적 없는 경우
  if(president == 0 )cout<<"1";
  else cout<<president;
  
  
  return 0;
}