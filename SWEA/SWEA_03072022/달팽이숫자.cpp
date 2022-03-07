#include <iostream>
#include <string>
#include <vector>

using namespace std;
void print(vector<vector<int>>vec1, int N){
    //print
    for(int i = 0 ; i<N ; i++){
        for(int j = 0 ; j<N ; j++){
            cout<<vec1[i][j]<<" ";
        }
        cout<<endl;
    }
}

//NxN크기의 달팽이 배열 출력
void solve(int N){
    vector<vector<int>>map(N, vector<int>(N));

    int rowStart = 0 , colStart = 0, rowEnd = N-1, colEnd = N-1;
    int num = 1;
    while(rowStart<=rowEnd && colStart <=colEnd){
        //가로 ->
        for(int i = colStart ; i<=colEnd ; i++){
            map[rowStart][i] = num++;
        }
       rowStart ++;

        //세로 (아래)
        for(int i = rowStart ; i<=rowEnd ;i++){
            map[i][colEnd] = num++;
        }
         colEnd--;
        //가로(아래)<-
        for(int i = colEnd; i>=colStart; i--){
            map[rowEnd][i] = num++;
        }
        rowEnd--;
        //세로(위)
        for(int i = rowEnd ; i>= rowStart ; i--){
            map[i][colStart] = num++;
        }
        colStart++;

    }
    print(map,N);
}

int main()
{
    int T;//test case
    cin>>T;
    for(int t = 1 ; t<=T; t++)
    {
        int N;
        cin>>N;
        cout<<"#"<<t<<endl;
        solve(N);
    }
}