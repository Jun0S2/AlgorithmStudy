#include <iostream>
using namespace std;
// https://school.programmers.co.kr/learn/courses/30/lessons/12980
int solution(int n)
{
    int ans = 0;

   while (n > 0) {
        if (n % 2 == 1) {  // n이 홀수라면 점프해야 함 (건전지 소모)
            ans++; // 점프 1회, 배터리 소모 1
            n--;  // 1칸 점프
        }
        n /= 2; // n이 짝수일 경우 순간이동 가능
    }
    
    return ans;
}
