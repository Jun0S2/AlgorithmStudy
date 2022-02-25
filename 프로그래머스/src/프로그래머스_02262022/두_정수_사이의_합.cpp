#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b)
{
    long long answer = 0;
    if (a == b)
        return a;
    long long start = a > b ? b : a;
    long long end = a > b ? a : b;
    for (long long i = start; i <= end; i++)
        answer += i;
    return answer;
}