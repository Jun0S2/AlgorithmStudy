#include <vector>
//https://school.programmers.co.kr/learn/courses/30/lessons/12914
// DP 문제
using namespace std;

long long solution(int n) {
    vector<long long> dp(n + 1);
    
    // 초기값 설정
    dp[1] = 1; // 1칸을 가는 방법은 1가지
    dp[2] = 2; // 2칸을 가는 방법은 2가지 (1+1 또는 2)

    // n이 2보다 작은 경우 예외 처리
    if (n == 1) return dp[1];
    if (n == 2) return dp[2];

    // DP
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // 결과값을 1234567로 나눈 나머지를 저장
    }

    return dp[n]; // n칸을 가는 방법의 수 반환
}
