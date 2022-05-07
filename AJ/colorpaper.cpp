#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<int>>map(101,vector<int>(101,0));
  
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  int x,y,area,height;//좌표 값
 

  cin>>N;//색종이의 장수
  for(int i = 1 ; i<=N ;i ++)//색종이 번호
  {
    cin>>x>>y>>area>>height;//좌표 get
    for(int nx = x; nx < x+area; nx++)
    {
      for(int ny = y ; ny < y+height ; ny ++)
      {
        map[nx][ny] =  i;
      }
    }
  }
  
  
for(int n = 1 ; n<=N ; n++)
  {
    int cnt = 0;
    for(int i = 0 ; i<101 ; i++)
    {
      for(int j = 0; j<101 ; j++)
      {
        if(map[i][j]==n)cnt++;
      }
    }
    cout<<cnt<<endl;
  }
  

  
  return 0;
}
