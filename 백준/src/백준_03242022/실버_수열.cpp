#include <iostream>
#include  <vector>

using namespace std;

//연속된 수열 중 가장 큰 합
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    //입력
    int N , K;
    cin >> N>> K;
    vector<int>input(N,0);
    for(int i = 0 ; i<N; i ++)  cin>> input[i] ; 
   

    //변수
    int cnt = 0;//경우의 수 카운터
    int sum = input[0] ;
    int R = 0, L = 0; //포인터
    int max = -9999;//최대 온도의 합

    //연속된 수들 :투포인터(차례대로), 정렬 불가
    while(L<=R && R<=N)
    {
        if(L+K>N)break;
        if(cnt ==  K-1 )
        {
            max = max < sum ? sum : max;//갱신
            cnt --; //한칸 뒤로 보내줌
            sum -= input[L++];
        }
        sum += input[++R];
        cnt++;
    }

    cout<<max;


    return 0;

}