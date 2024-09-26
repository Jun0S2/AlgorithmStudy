/**
https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=cpp
스택 문제 (같은거 제거..헉..)
잊고있던 유형
*/

#include <iostream>
#include <string>
#include <stack>

using namespace std;

int solution(string s) {
    stack<char> stk; // 빈 스택

    for (char ch : s) {

        if (!stk.empty() && stk.top() == ch) {
            stk.pop(); // 스택 맨 위와 레터 같음
        } else {
            stk.push(ch); // 스택 안에 아무것도 없거나 다를 경우
        }
    }
    
    return stk.empty() ? 1 : 0;
}
