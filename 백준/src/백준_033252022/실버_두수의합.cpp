#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, X;
    cin>>N;
    vector<int>input(N,0);
    for(int i = 0 ; i<N ; i++)cin>>input[i];
    cin>>X;//target sum
    sort(input.begin(), input.end());

    int L = 0, R = N-1;
    int sum = 0;
    int answer = 0;//cnt

    // 1 2 3 4 5 6 7 8 9 10 이 있을 때, 만약 합이 11이 되는 수를 구하는거면,
    // 10+1, 9+2, 8+... 처럼 하나 발견하면 그 수를 중심으로 ++ -- 하는거니까 양끝에서 오기

    while(L<R)
    {
        sum = input[L] + input[R];
        if(sum == X)
        {
            answer ++;
            L++;R--;
        }
        else if(sum > X) //L이 오른쪽으로 가면 숫자는 더 커짐 => R을 왼쪽으로
        {
            R--;
        }
        else
        {
            L++;
        }
    }

    cout<<answer;
    
    return 0;
}