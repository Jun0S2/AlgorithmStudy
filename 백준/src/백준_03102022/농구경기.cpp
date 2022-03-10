#include <vector>
#include <string>
#include <algorithm>
#include <iostream>

using namespace std;

int N; //선수의 수

int main(){
    cin >> N;
    vector<string>players(N);
    for(int i = 0 ; i<N ; i++) cin>>players[i];

    //정렬시키기
    sort(players.begin(), players.end());

    char lastName = 'a';
    int cnt = 0;
    string answer = "";

    for(auto i : players)
    {
        if(lastName == i.at(0))
        {
            cnt ++;
        }
        else
        {
            if(cnt>=5) answer += lastName;
            //초기화
            lastName = i.at(0);
            cnt = 1;
        }
    }
    //마지막 cnt 세기
    if(cnt>=5) answer += lastName;
    if(answer=="")cout<<"PREDAJA";
    else cout<<answer;

}