//https://school.programmers.co.kr/learn/courses/30/lessons/12945
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<long> sums;
// fibo
void dfs(int depth, int goal) { // 이전 두 수의 합
    long prev2 = sums[depth-2];
    long prev1 = sums[depth-1];
    // 피보나치 수를 구할 때마다 모듈로 연산 적용
    sums.push_back((prev2 + prev1) % 1234567);
    if (depth == goal) return;
    dfs(depth + 1, goal);
}

int solution(int n) {
    int answer = 0;
    sums.push_back(0); // 0번째 피보나치 수 0
    sums.push_back(1); // 1번째 피보나치 수 1
    
    if (n > 1) dfs(2, n); // get vector
    
    return sums[n];
}

