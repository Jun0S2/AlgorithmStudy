#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s) {
    stack<char> st;
    for (auto ch : s) {
        // opening Parenthesis
        if(ch == '(') st.push(ch);
        else { // closing parenthesis
            if (st.empty())return false;
            if(st.top()=='(') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
    }
    if (st.size()>0)return false;
    else return true;
}
