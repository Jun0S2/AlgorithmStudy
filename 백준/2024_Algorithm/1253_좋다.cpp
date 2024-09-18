#include <vector>
#include <iostream>
/**
 * @date 2024.09.19
 * @author June Park
 * Two Pointer
 */
using namespace std;
int N;
vector<int> input;
int main()
{
    ios::sync_with_stdio(0);
    cout.tie(0);
    cin >> N;
    input.resize(N);
    for (int i = 0; i < N; i++)
    {
        cin >> input[i];
    }

    int answer = 0;                                              // 좋은 수의 개수
    for (int currentIndex = 0; currentIndex < N; currentIndex++) // iterate
    {
        int L = 0, R = N - 1; // pointer
        while (L < R)         // 이분 탐색으로 찾는다.
        {
            if (currentIndex == L) // 인덱스가 L 이면 한칸 오른쪽으로 이동
            {
                L++;
                continue; // 다음으로 건너뜀
            }
            if (currentIndex == R)
            { // 인덱스가 R 이면 한칸 앞으로 이동
                R--;
                continue;
            }
            int sum = input[L] + input[R];
            if (sum == input[currentIndex])
            {
                answer++;
                break; // 다음 currentIndex 로 넘어간다.
            }
            // 찾지 못했으면 다시 있는 곳에서 탐색
            // 목표보다 합이 작으면, 정렬된 배열의 left pointer 를 오른쪽으로 옮기면 커짐
            else if (sum < input[currentIndex])
            {
                L++;
            }
            // 목표보다 합이 크면, 정렬된 배열의 right pointer 를 앞으로 옮기면 숫자가 작아짐
            else
            {
                R--;
            }
        }
    }
    cout << answer << '\n';
    return 0;
}
