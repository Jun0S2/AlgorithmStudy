//https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=cpp
#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    int count = 0; // 여는 괄호와 닫는 괄호의 균형을 맞추기 위한 변수

    for (char ch : s) 
    {
        if (ch == '(') {
            count++; // 여는 괄호가 나오면 1 증가
        } else if (ch == ')') {
            count--; // 닫는 괄호가 나오면 1 감소
            if (count < 0) return false; // 여는 괄호보다 닫는 괄호가 많아지면 false 반환
        }
    }

    return count == 0; // 마지막에 count가 0이어야 균형이 맞음
}
