#include <iostream>
#include <vector>

using namespace std;

//연속된 수열 중 가장 큰 합
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    //입력
    int N , K;
    cin >> N>> K;
    vector<int>input(N,0);
    vector<int>index;//라이언의 인덱스를 저장
    for(int i = 0 ; i<N; i ++)  
    {
        cin>> input[i] ; 
        if(input[i]==1)index.push_back(i);
    }
    if(index.size()<K){cout<<"-1";return 0;} //개수 모자람

    //index : 0 4 6 9 라면 이 안에서 K 개 뽑는것의 길이 찾으면 됨(B-A+1)개
    int minLen = N+1;
    for(int i =0 ; i<=index.size()-K ; i++)
    {
      // cout<<index[i]<<"and "<<index[i+K-1];
        int len = index[i+K-1] - index[i] +1  ;
      //  cout<<len<<endl;
        minLen = len < minLen ? len : minLen;
    }
    cout<<minLen;
   
    return 0;

}