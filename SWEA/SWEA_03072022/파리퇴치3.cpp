#include <iostream>
#include <string>
#include <vector>

using namespace std;

//position x,y에서부터 가로 세로의 합
int Across(int x, int y, vector<vector<int>>map, int N, int M){
    int sum = 0;
    for(int i = 0 ; i< M ; i ++){ 
        sum += map[x][i];//가로 합
        sum += map[i][y];//세로 합
    }
    return sum;
}

//x,y에서부터 대각선 위 아래합
int Cross(int x, int y, vector<vector<int>>map, int N, int M){
    //대각선 아래부분
    int dx[] = {1,1,-1,-1};
    int dy[] = {1,-1,-1,1};
    int sum = 0;
    for(int d = 0 ; d<4 ; d++){
        for(int i = 1 ; i< M  ;i++){
            int nx = x + dx[d]*i;
            int ny = y + dy[d]*i;
            if(nx<0||nx>=N||ny<0||ny>=N)continue;
            sum += map[nx][ny];
        }
    }
    return sum;
}

int solve(vector<vector<int>>map , int N, int M){
  int  maxSum = 0;
  for(int i = 0 ; i<N ; i++){
      for(int j = 0 ; j<N ; j++){
          int across = Across(i,j,map,N,M);
          int cross = Cross(i,j,map,N,N);
          maxSum = across > maxSum ? across : maxSum;
          maxSum = cross > maxSum ? cross : maxSum;
      }
  }
  return maxSum;
}

int main(){
    int T, N, M;
    cin>>T;
    for(int t= 1; t<=T; t++){
        cin>>N>>M;
        vector<vector<int>> map(N,(vector<int>(N,0)));
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j<N ; j++){
                cin>>map[i][j];
            }
        }//end of input
        cout<<"#"<<t<<" "<<solve(map ,N, M)<<endl;//맵과 강도
        //print answer
    }
}