#include <string>

using namespace std;
int solution(int n)
{
    int answer = 0;
    string digits = to_string(n);
    for (char c : digits)
        answer += c - '0';

    return answer;
}