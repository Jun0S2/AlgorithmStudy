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
    int minLen = 100000;//가장 짧은 길이
    int sum ;//N만 넘으면 컷해도 됨(짧은 길이 구하니까!)
    int cnt ;//길이 카운터
    //연속된 수들 :투포인터(차례대로), 정렬 불가
    for(int i = 0 ; i < input.size() -1 ; i++ )
    {
        // 초기화
        sum = input[i];
        cnt = 1;
        
        for(int j = i+1 ; j < input.size() ; j++)
        {
            sum += input[j];
            cnt++;
            if(sum >= S )
            {
                minLen = cnt < minLen ? cnt : minLen;
                break;
            }
            if(cnt>=minLen)break; //의미가 없으니 가지치기
        }
    }

    cout<<((minLen==100000)?0:minLen);


    return 0;

}