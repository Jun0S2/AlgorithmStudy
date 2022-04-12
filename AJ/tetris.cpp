#include <iostream>
#include <vector>

using namespace std;

int C,R;
vector<vector<int>>map;

int main(){


  /* Get Input */ 
  cin>>C>>R;
  map.assign(R,vector<int>(C,0));
  
  for(int i = 0 ; i< R ;i ++)
  {
    for(int j = 0 ; j<C ; j++)
    {
      cin>>map[i][j];
    }
  }
    
    vector<int>rows;
    
    /* Find available spaces */
    for(int i = 0 ; i<C ; i++)//columns 
    {
      if(map[0][i]==0 && map[1][i]==0 && map[2][i] == 0 && map[3][i]==0)
      { 
        rows.push_back(i);
      }
    } 
    
    /* Print rows */
    //for(auto i :  rows)cout<<i<<endl;
    /* Game Over */
    if(rows.empty()){cout<<"0 0";return 0;}
  
    /* Find Max */
    int maxX = 0;//X의 자리 *왼쪽에서 x번째
    int maxY = 0;//깨지는 테트리스 row 넘버
    
    for(int i = 0 ; i<rows.size() ;i++ )//columns
    {
       int col = rows[i];
      //가장 끝까지 들어가서 1앞이나 맨 끝이 시작자리임
      int flag = R-1;
      for(int j = 0 ; j< R ; j++)//1을 만나거나 끝까지 오면 break
      {
        //끝까지 온 경우
        if(map[j][col]==1){flag = j-1; break;}//1을 만난 경우
      }
    // cout<<flag<<endl;
      /* Fill */
      map[flag-3][col]=map[flag-2][col]=map[flag-1][col]=map[flag][col]=1;
      /* Count : 가로 깨지는 수  */
      int brokeCnt = 0;
      for(int r = 0; r<R; r++)
      {
        bool cool = true;
        for(int c = 0; c<C ; c++)
        {
          if(map[r][c]==0){cool = false;break;}
        }
        if(cool)brokeCnt++;
      }
      if(brokeCnt>maxY){maxY = brokeCnt; maxX = rows[i]+1;}
     /* UnFill */
      map[flag-3][i]=map[flag-2][i]=map[flag-1][i]=map[flag][i]=0;
    }
    
    cout<<maxX<<" "<<maxY<<endl;
  
}
