#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers)
{
    int answer = 0;
    vector<int> counter(10, 0); // 0~9까지 cnt값을 0으로 초기화

    for (auto n : numbers)
        counter[n] += 1;
    for (int i = 0; i < 10; i++)
        answer += (counter[i] == 0) ? i : 0;

    return answer;
}