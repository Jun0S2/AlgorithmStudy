#include <string>
#include <vector>

using namespace std;

int solution(int num)
{
    int answer = 0;
    int cnt = 500;
    long number = (long)num; //이부분..
    while (cnt > 0)
    {
        if (number == 1)
            return answer; // end case
        if (number % 2 == 0)
            number /= 2;
        else
            number = (number * 3) + 1;
        ++answer;
        --cnt;
    }
    return -1;
}