#include <iostream>
#include  <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    //입력
    int N , S;
    cin >> N>> S;
    vector<int>input(N,0);
    for(int i = 0 ; i<N; i ++)  cin>> input[i] ; 
   

    //변수
    int cnt = 0;//경우의 수 카운터
    int sum = 0 ;
    int R = 0, L = 0; //포인터


    //연속된 수들 :투포인터(차례대로), 정렬 불가
    while(L<=R && R<=N)
    {
      if(sum >= S) //크거나 같으면 다음 포인터로 넘겨줘야함
      {
          if(sum == S) cnt++;
          sum -= input[L++];
      }
      else //우측 포인터 다음칸으로 넘겨서 더함
      {
          sum +=  input[R++];
      }
    }

    cout<<cnt;


    return 0;

}