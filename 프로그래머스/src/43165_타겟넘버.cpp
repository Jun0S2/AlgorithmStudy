#include <string>
#include <vector>
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
using namespace std;

vector<int> NUMBERS;
int answer = 0;

void dfs(int depth, int target, int sum) {
    // 재귀의 깊이가 NUMBERS의 크기와 같으면 종료 조건
    if (depth == NUMBERS.size()) {
        if (sum == target) {
            answer++; // 목표 합에 도달하면 정답 카운트 증가
        }
        return;
    }
    
    // 현재 숫자를 더하거나 빼는 두 가지 경우로 재귀 호출
    dfs(depth + 1, target, sum + NUMBERS[depth]); // 더하기
    dfs(depth + 1, target, sum - NUMBERS[depth]); // 빼기
}

int solution(vector<int> numbers, int target) {
    NUMBERS = numbers;
    dfs(0, target, 0);
    return answer;
}
