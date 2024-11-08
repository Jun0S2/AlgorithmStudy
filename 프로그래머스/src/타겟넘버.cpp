#include <string>
#include <vector>
#include <iostream>
using namespace std;
int answer = 0;
// https://school.programmers.co.kr/learn/courses/30/lessons/43165 
void dfs(int depth, const vector<int> numbers, const int target, int sums) {
    if(depth == numbers.size()) { // 모두 visit 함.
        // cout << sums << endl;
        if (sums == target) {
            answer ++;
        }
        return;
    }
    dfs(depth+1, numbers,target,sums+numbers[depth]);
    dfs(depth+1, numbers,target,sums-numbers[depth]);
}

int solution(vector<int> numbers, int target) {
    vector<bool> visited(numbers.size(),false);
    dfs(0,numbers,target,0);
    return answer;
}
