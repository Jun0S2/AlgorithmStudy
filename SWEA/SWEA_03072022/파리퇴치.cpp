#include <iostream>
#include <string>
#include <vector>

using namespace std;
/*완탐 MxM*/
int solve(vector<vector<int>>map , int N, int M){
  int max = 0;
  for(int i = 0 ; i<=N-M ; i++){
      for(int j = 0 ; j<=N-M ; j++){
          int sum = 0;
          for(int k = 0 ; k<M; k++){
              for(int l = 0; l<M ; l++){
                  sum += map[i+k][j+l];
              }
          }
          max = max<sum ? sum : max;
      }
  }
  return max;
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
       
        //print answer
        cout<<"#"<<t<<" "<< solve(map ,N, M)<<endl;//맵과 강도
    }
}