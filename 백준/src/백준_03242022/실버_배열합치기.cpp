#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    //입력
    int A , B;
    cin >> A>> B;
    priority_queue<int, vector<int>,greater<int>>pq;
    int input;
    for(int i = 0 ; i<A ; i++) {cin>>input; pq.push(input);}
    for(int i = 0; i<B; i++){cin>>input; pq.push(input);}
    while(!pq.empty()){cout<<pq.top()<<" "; pq.pop();}
    return 0;

}