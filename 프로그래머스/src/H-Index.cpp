#include <string>
#include <vector>
#include <algorithm>
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end(), greater<int>());
    int h = 0;
    for (int i = 0 ; i<citations.size();i++) {
        //h 번이상 인용된 논문이 h 개 이상이여야함.
        // 6번 인용된 논문이 1개 이상 (6>=1) - ok
        // 5번 인용된 논문이 2개 ㅇ리상 (5>=2) - ok
        // 3번 인용된 논문이 3개 이상(3>=3) - ok
        // 1번 인용된 논문이 4개 이상 (1 < 4)  - not ok
        // 0번 인용된 논문이 5개 이상
        if(citations[i]>= i+1) { 
            h = i+1;
        } else {
            break;
        }
    }
    return h;
}
