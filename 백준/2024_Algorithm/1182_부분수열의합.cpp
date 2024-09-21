#include <iostream>
#include <vector>

/**
 * @date 09.21.2024
 * @author June Park
 * 부분수열의합
 * https://www.acmicpc.net/submit/1182
 */
using namespace std;
int N, S;
vector<int> numbers;
int available = 0;

// 부분 수열을 전부 구하고 endcase 에서 그 합이 S 와 동일한지 본다
void powerset()
{
    int maxValue = 1 << N; // 2^N 개
    for (int i = 0; i < maxValue; i++)
    { // 모든 경우의 수
        int sum = 0;
        for (int j = 0; j < N; j++)
        { // 모든 수
            if (i & 1 << j)
            {
                sum += numbers[j];
            }
        }
        if (sum == S)
            available++;
    }
}
int main()
{
    cin >> N >> S;
    numbers.resize(N);
    for (int i = 0; i < N; i++)
    {
        cin >> numbers[i];
    }
    powerset();
    if (S == 0)
        available--; // 공집합
    cout << available << '\n';
    return 0;
}