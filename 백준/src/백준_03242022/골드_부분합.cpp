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
    for(int i = 0 ; i<N; i ++) 
    { 
        cin>> input[i] ; 
        if(input[i]>=S) //길이가 1인 경우
        { 
            cout<<"1";
            return 0;
        }
    }

    //변수
    int minLen = N+1;//가장 짧은 길이
    int sum = 0 ;
    int R = 0, L = 0; //포인터


    //연속된 수들 :투포인터(차례대로), 정렬 불가
    while(L<=R)
    {
        int len = R-L;
        if(sum >= S) //현재 포인터 합이 S보다 크거나 같으면, left땡겨준다
        {
            minLen = minLen < len ? minLen : len;
            sum -= input[L++];// Left를 다음칸으로 넘김
        }
        else if(R == N) break;
        else sum += input[R++]; // 다음 원소 더해줌
    }
    cout<<((minLen==N+1)?0:minLen);


    return 0;

}