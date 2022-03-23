#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    //입력
    int N, M;
    cin>>N>>M;
    vector<int>input(N,0);
    for(int i = 0 ; i<N ; i++) cin>>input[i];
    sort(input.begin(), input.end());

    //연속된 수열 최소차이 구하기
    int L=0, R=1, min = 200000001;
    int diff;

    while(L<N && R<N)
    {
       diff = input[R] - input[L];
       if(diff>=M)
       {
           if(diff==M) {cout<<M<<endl;return 0;}
           min = diff < min ? diff : min;
           L++;
       }
       R++;
    }

    cout<<min;
    return 0;

}