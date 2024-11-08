#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int left = 0;
    int right = 0;
    vector<pair<int,int>> sortedSizes;
//    {50 60 , 30 70, 30 60, 40 80} -> max : 50, 80 
    // sort
    for (auto s : sizes) {
        if (s[0]>=s[1]) {
            sortedSizes.push_back({s[0], s[1]});
        } else{
            sortedSizes.push_back({s[1],s[0]});
        }
    }
    // max 가 무조건 왼쪽에 오고있음
    for(auto s : sortedSizes) {
        left = left<s.first ? s.first:left;//max
        right = right< s.second ? s.second : right; //max
    }

    return right * left ;
}
