#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(int x)
{
    // step 1 : string으로 변환
    string digits = to_string(x);
    // step 2 : 각 자릿수 더하기
    int sum = 0;
    for (int i = 0; i < digits.size(); i++)
    {
        sum += (digits.at(i) - '0');
    }

    return x % sum == 0 ? true : false;
}