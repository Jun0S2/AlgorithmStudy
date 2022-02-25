#include <string>
#include <vector>

using namespace std;

int solution(string s)
{
    int answer = 0;
    bool isMinus = false;
    int tens = 1;

    //맨 앞이 -면 연산 후에 -1 곱해줘야함
    for (int i = s.size() - 1; i >= 0; i--)
    {
        int curr = s.at(i) - '0';
        if (i == 0) //부호인지 확인
        {
            if (s.at(i) == '-' || s.at(i) == '+') //부호인 경우
            {
                isMinus = s.at(i) == '-' ? true : false;
            }
            else
                answer += (curr * tens); //숫자인 경우
        }
        else
            answer += (curr * tens);
        tens *= 10;
    }

    return isMinus ? answer * (-1) : answer;
}