#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
// https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=cpp
using namespace std;

/**
 * 소수 판별을 
 * 에라토스테네스의 체 -> 소수가 아닌애들을 채우는방법
 */
void simulate(vector<bool>& isPrime) {
    int maxNumber = isPrime.size() - 1;
    isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님
    
    for (int i = 2; i <= sqrt(maxNumber); i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= maxNumber; j += i) {
                isPrime[j] = false; // i의 배수들은 소수가 아님
            }
        }
    }
}

int solution(string numbers) {
    int answer = 0;
    vector<bool> isPrime(9999999, true); // 최대 7자리 수의 소수 여부를 확인
    simulate(isPrime);
    
    // 각 숫자를 조합하여 소수를 찾아야 함
    // 예를 들어 numbers가 "17"이면 가능한 조합은 1, 7, 17, 71 등
    sort(numbers.begin(), numbers.end());
    do {
        for (int i = 1; i <= numbers.size(); i++) {
            int num = stoi(numbers.substr(0, i));
            if (isPrime[num]) {
                answer++;
                isPrime[num] = false; // 중복 카운트 방지
            }
        }
    } while (next_permutation(numbers.begin(), numbers.end()));
    
    return answer;
}
