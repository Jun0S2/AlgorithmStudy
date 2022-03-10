#include <iostream>
#include <string>
#include <vector>
/*시간초과 -> DP로 풂*/
using namespace std;

int main(){
    int N,K;
    cin>>N>>K;
    vector<int>temperature(N,0);
    vector<int>D(N,0);
   
    int sum = 0;
    for(int i = 0 ; i<N ; i++) cin>>temperature[i];
    for(int i = 0 ; i<K ; i++) sum = sum + temperature[i];//1~K번쨰 합

    D[0] = sum;
    int max = sum;

    for(int i = 0 ; i<N-K ; i++)
    {
        D[i+1] = D[i] +  temperature[i+K] - temperature[i];//마지막 원소까지 더함
        max = max < D[i+1] ? D[i+1] : max;
    }
    cout<<max;

}