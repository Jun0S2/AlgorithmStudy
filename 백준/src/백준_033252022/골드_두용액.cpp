#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N ;//용액의 수
    cin>>N;
    vector<int> input(N,0);
    for(int i = 0 ; i < N ; i ++) cin>>input[i];

    //정렬
    sort(input.begin(), input.end());

    //변수
    int A=0,B=0;
    int answer = 0x7fffffff;//diff가 가장 작은 수를 찾는거임
    int L=0, R = N - 1; //투포인터

    //1 2 3 4 5  => 5+1이 5+2 보다 작다
    //특성값이 0에 가장 가까운 용액을 만듦.
    while(L < R)
    {   
        if(abs(input[L]+input[R]) < answer )
        {
            answer = abs(input[L]+ input[R]); //최솟값 갱신(절댓값필요)
            A = input[L]; //두 값 저장
            B = input[R];
        }
        //최적화
        if(input[L] + input[R] > 0) R--; //이미 합이 양수면, L을 다음으로 넘어가면 합이 더 커질 뿐이니까 R을 넘어간다
        else L++; //아직 음수이므로 0에 더 가까워 지기 위해서는 L을 더 큰 숫자를 더해야 한다

    }
    cout<<A<<" "<<B;

    return 0;
}