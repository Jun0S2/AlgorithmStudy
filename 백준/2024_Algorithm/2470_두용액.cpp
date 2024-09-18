#include <iostream>
#include <vector>
#include <algorithm>
/**
 * @author June Park
 * @date 2024.09.19
 */
using namespace std;

int N; // 용액의 수
vector<int> input;

int main()
{
    // GET INPUT
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    input.resize(N);
    for (int i = 0; i < N; i++)
        cin >> input[i];

    // SORT
    sort(input.begin(), input.end());

    // SEARCH
    int L = 0, R = N - 1;    // two pointer
    int answer = 0x7fffffff; // 차이가 가장 작은 값으로 초기화
    int A = 0, B = 0;        // 두 용액 값

    // 1 2 3 4 5 -> 5+1이 5+2보다 작음
    while (L < R)
    {
        if (abs(input[L] + input[R]) < answer)
        { // 차이가 더 작은 용액 발견
            A = input[L];
            B = input[R];                      // 용액 업데이트
            answer = abs(input[L] + input[R]); // min 값 업데이트
        }
        // 최적화
        if (input[L] + input[R] > 0)
            R--; // 합이 양수이면, 다음 값으로 넘어가면 값이 더 커지므로 R을 감소
        else
            L++; // 아직 합이 음수이면 L을 증가
    }
    cout << A << " " << B;
}
