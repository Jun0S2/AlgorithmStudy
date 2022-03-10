#include <iostream>
#include <vector>
#include <string>

using namespace std;

//분할정복
long long dfs(long long A, long long B, long long C){
    if(B==1)return A%C;

    long long temp = dfs(A,B/2,C);
    temp = temp * temp % C;

    if(B%2==0)return temp;
    else return temp * A%C;
}

int main (){
    ios::sync_with_stdio(0);
	cin.tie(0);
    long long A,B,C;
    cin>>A>>B>>C;
    cout<<dfs(A,B,C);
 
}