//https://school.programmers.co.kr/learn/courses/30/lessons/12951#
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool isNumber(char c) {
    if ((c>=65 && c<=90) || (c>=97&&c<=122)) return false;
    return true;
}
// 97-65 = 32
char to_upper(char c) {
    if (c >=65&& c <=90) return c; // already upper case
    else if (c>=97 && c <=122 ) return (c-32);
    return c;
}

char to_lower(char c) {
    if (c>=97 && c<=122) return c; // already smaller case
    else if (c>=65 && c<=90) return (c+32); //97
    return c;
}
string solution(string s) {
    bool firstLetter = true;
    for (int i = 0 ; i < s.size(); i++) {
        if (firstLetter) {
            if (s[i] == ' ') { continue;}
            firstLetter =false;
            if(isNumber(s[i])) continue;
            else s[i] = to_upper(s[i]);
        } else {
            if (s[i] == ' ') { firstLetter = true; continue;}
            s[i] = to_lower(s[i]);
        }
    }
  
    return s;
}
