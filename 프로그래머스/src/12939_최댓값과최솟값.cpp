//https://school.programmers.co.kr/learn/courses/30/lessons/12939
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

map<char, int> translate = {
    {'0', 0}, {'1', 1}, {'2', 2}, {'3', 3}, {'4', 4},
    {'5', 5}, {'6', 6}, {'7', 7}, {'8', 8}, {'9', 9}};

string solution(string s) {
    vector<int> numbers;
    int pos = 1; // 부호 결정
    int temp = 0; // 숫자
    bool isNumber = false; // 숫자를 추적하기 위한 변수

    for (auto charr : s) {
        if (charr == ' ') { // 숫자가 끝났을 때
            if (isNumber) { // temp가 유효할 때만 push
                numbers.push_back(temp * pos);
                pos = 1; // 부호 초기화
                temp = 0; // 숫자 초기화
                isNumber = false;
            }
        } else { 
            if (charr == '-') {
                pos = -1; // 음수 처리
            } else { // 숫자 처리
                int curr = translate[charr];
                temp = temp * 10 + curr; // 자릿수를 유지하며 숫자를 누적
                isNumber = true;
            }
        }
    }

    // 마지막 숫자가 남아있을 경우 처리
    if (isNumber) {
        numbers.push_back(temp * pos);
    }

    // 오름차순 정렬
    sort(numbers.begin(), numbers.end());

    // 결과 반환: 최소값과 최대값
    string answer = to_string(numbers[0]) + " " + to_string(numbers[numbers.size() - 1]);
    return answer;
}
