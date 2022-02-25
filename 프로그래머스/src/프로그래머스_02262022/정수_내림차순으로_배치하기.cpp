#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n)
{
    long long answer = 0;
    string digits = to_string(n);
    vector<long long> input(digits.size());
    int zeros = digits.size();
    int tens = 1;

    for (int i = 0; i < zeros; i++)
        input.emplace_back(digits.at(i) - '0');
    sort(input.begin(), input.end(), greater<int>()); //정렬없이 할수있는법을 모르겠다

    for (int i = zeros - 1; i >= 0; i--)
    {
        answer += (input[i] * tens);
        tens *= 10;
    }

    return answer;
}