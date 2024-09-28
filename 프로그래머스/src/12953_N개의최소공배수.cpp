#include <vector>
#include <algorithm>
// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// 최소공배수, 최대공배수
using namespace std;

// 유클리드 호제
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// 두 수의 최소공배수(LCM) 계산
int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}

int solution(vector<int> arr) {
    int answer = arr[0]; // 첫 번째 값을 초기 LCM으로 설정

    for (int i = 1; i < arr.size(); i++) {
        answer = lcm(answer, arr[i]); // 현재까지의 LCM과 다음 수의 LCM을 계산
    }

    return answer; // 배열의 모든 수의 최소공배수 반환
}
