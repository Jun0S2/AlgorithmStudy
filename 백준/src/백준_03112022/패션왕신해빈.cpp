#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;
//경우의수 (타입 +1(공집합)) * (타입2 +1) .... -1(전체공집합)
int main(){
int N,M;
cin>>N;
    for(int t = 0 ; t<N ; t++){
        
        unordered_map<string,int>outfit;//종류, 개수
        string name,type;
        cin>>M;
        
        for(int i = 0 ; i<M ; i++)
        {
            cin>>name>>type;
            outfit[type] += 1;//같은 이름을 가진 의상 x ->그냥 cnt
        }

        int pos = 1;
        for(auto i : outfit) pos *= (i.second+1);
        cout<<pos-1<<endl;
    }
}