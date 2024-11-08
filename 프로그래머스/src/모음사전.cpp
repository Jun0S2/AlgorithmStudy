#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
using namespace std;

string str = "AEIOU";
int countComb = 0;
int answer = 0;
// 중복 조합을 생성하기 위한 DFS 함수
void dfs(string current, int depth, const string& word) {
    if (current == word) {
        answer = countComb;
        return;
    }
    if (depth == 5) {
        return;
    }

    for (int i = 0; i < str.size(); i++) {
        countComb ++;
        string checkWord = current+str[i];
        dfs(current + str[i], depth + 1, word);
    }
}

int solution(string word) {
    dfs("", 0 , word);
    return answer;
}
