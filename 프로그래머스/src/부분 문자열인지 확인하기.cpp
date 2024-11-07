#include <string>
#include <vector>
#include <iostream>
using namespace std;
//https://school.programmers.co.kr/learn/courses/30/lessons/181843?language=cpp

int solution(string my_string, string target) {
    std::size_t pos = my_string.find(target);      // position of "live" in str
    if (pos <= 100 && pos >= 0) return 1;
    else return 0;
}
