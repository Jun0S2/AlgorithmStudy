// https://school.programmers.co.kr/learn/courses/30/lessons/42885
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    // 이거 sorting 하면 안됌?
    sort(people.begin(), people.end());
    int startPtr = 0 ;
    int endPtr = people.size()-1;
    // cout << people[startPtr] << " and " << people[endPtr] << endl;
    while(startPtr<= endPtr) {
        if (people[startPtr] + people[endPtr] <= limit) {
            startPtr++;
            endPtr--;
            answer++; // 구명 보트 한개면 가능
        } else {
            endPtr--;
            answer++;
        }
    }
    return answer;
}
