#include <string>
#include <vector>
#include <algorithm>

using namespace std;
/*
실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
find : 실패율이 높은 스테이지부터 스테이지 내림차순
*/

bool compare(const pair<int,double> &v1 , const pair<int, double> &v2){
    if(v1.second == v2.second) return v1.first < v2.first; 
    return v1.second > v2. second; //내림차순
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;//index용
    vector<pair<int,double>> failure;
    
    int total = stages.size();//헐..내가 계속 실수함..별 쇼를 했는데 이럴수가..
    
    for(int i = 1 ; i<= N ; i++)//각 스테이지
    {
        int cnt = 0;
        for(int j = 0 ; j<stages.size() ; j++)//모든 사용자 스테이지 정보확인
        {
            if(stages[j]==i) cnt++;
        }
        if(total==0) failure.push_back(make_pair(i,0));
        else 
        {
            failure.push_back(make_pair(i,(double)cnt/total));
        total -= cnt;
        }
    }

    sort(failure.begin(), failure.end(), compare);
    for( int i = 0 ; i< N ; i++) answer.emplace_back(failure[i].first);//인덱스만 넣기
   
    return answer;
}