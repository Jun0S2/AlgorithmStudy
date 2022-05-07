#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>>map(8,vector<int>(8,0));//사이즈를 잘못잡아서 생겼던 문제...
vector<int>king(2,0);
vector<vector<int>>rook;

/*
 y : col, x : row 
*/
bool findVert(int x, int y)
{
  for(int i = x-1 ; i>=0 ; i--)
  {
    if(map[i][y]==1)return true;//king
    else if (map[i][y]==3) break;//일반
  }
  for(int i = x+1 ; i<8 ; i ++)
  {
    if(map[i][y]==1)return true;//king
    else if (map[i][y]==3) break;//일반v
  }
  return false;
}

bool findHorz(int x, int y)
{
  for(int i = y-1 ; i>=0 ; i--)
  {
    if(map[x][i]==1)return true;//king
    else if (map[x][i]==3) break;//일반
  }
  for(int i = y+1 ; i<8 ; i ++)
  {
    if(map[x][i]==1)return true;//king
    else if (map[x][i]==3) break;//일반v
  }
  return false;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int num = 0;
  
  for(int i = 0 ; i< 8 ; i++)
  {
    for(int j = 0 ; j< 8 ; j++)
    {
        cin>>map[i][j];
        if(map[i][j]==1) { king[0] = i; king[1] =j;}
        else if (map[i][j]==2) {rook.push_back({i,j}); num++;}
    }
  }
  if(num==0){cout<<"0";return 0;}

  
  //iterate
   for(int i = 0 ; i< rook.size() ; i++)
   {
     //rook 의 좌표
     int x = rook[i][0];
     int y = rook[i][1];

     if(findVert(x ,y)||findHorz(x,y))
     {
       cout<<"1";
       return 0;
     }

   }
  cout<<"0";
  return 0;
}
