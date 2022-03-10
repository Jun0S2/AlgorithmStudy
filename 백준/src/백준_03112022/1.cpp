#include <iostream>
#include <string>
#include <vector>

using namespace std;
//(A+B)%C 와 (A%C + B%C) %C는 같다
int main(){
    ios::sync_with_stdio(0);
	cin.tie(0);
    int N;
    while(cin>>N){
        int cnt  =  1;
        int temp = 1;
        while(true)
        {
            if(temp % N ==0 )break;
            cnt++;
            temp = ((temp*10)+1)%N;//다음 자리수
        }
        cout<<cnt<<"\n";
    }
}