#include <iostream>
#include <vector>

using namespace std;


int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  vector<vector<int>>map(5,vector<int>(5,0));
  
  //입력 받기
  for(int i= 0 ; i< 5 ; i++)
  {
    for(int j = 0 ; j< 5 ; j++)
    {
      cin>>map[i][j];
    }
  }
  
  vector<vector<int>>mapCopy = map;
  
  //상하좌우
  vector<int> dx = {-1,1,0,0};
  vector<int> dy = {0,0,-1,1};

  for(int i = 0 ; i< 5 ; i++)
  {
    for(int j = 0 ; j< 5 ; j++)
    {
      //사방탐색 : 현재를 기준으로 : nx ny가 더 크면 현재는 더 작은것임
      int bigger = 0;
      int smaller = 0;
      //bigger + smaller 하면 범위 넘었는지도 알 수 있다.
      
      for(int d = 0 ; d< 4 ;d ++)
      {
        int nx = dx[d] + i;
        int ny = dy[d] + j;
        if(nx < 0 || ny<0 || nx >=5 || ny>=5)continue;
        //else
        if(map[nx][ny] > map[i][j])smaller++;
        else bigger++;
      }
      if(smaller !=0 && bigger ==0) mapCopy[i][j] = -1;
    }
  }
  
  //print
  for(int i = 0 ; i<5 ; i++)
  {
    for(int j = 0 ; j<5 ; j++)
    {
      if(mapCopy[i][j] <0)cout<<"*"<<" ";
      else cout<<mapCopy[i][j]<<" ";
    }
    cout<<endl;
  }
  return 0;
}
