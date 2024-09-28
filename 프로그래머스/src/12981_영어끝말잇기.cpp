#include <string>
#include <vector>
#include <iostream>
// https://school.programmers.co.kr/learn/courses/30/lessons/12981
using namespace std;

// 단어의 마지막 글자 반환
char returnLastString(string word) {
    return word[word.size() - 1];
}

// 단어의 첫 글자 반환
char returnFirstString(string word) {
    return word[0];
}

// 이전에 같은 단어가 나왔는지 확인
bool returnDuplicated(vector<string> words, string comp, int index) {
    for (int i = 0; i < index; i++) { // 이전에 나온 단어와 비교
        if (words[i] == comp) {
            return true;
        }
    }
    return false;
}

vector<int> solution(int n, vector<string> words) {
    vector<int> answer(2, 0);

    for (int i = 1; i < words.size(); i++) {
        // 이전 단어의 마지막 글자와 현재 단어의 첫 글자 비교
        char prev = returnLastString(words[i - 1]);
        char first = returnFirstString(words[i]);

        // 중복 단어 체크 또는 단어 연결이 잘못된 경우
        if (returnDuplicated(words, words[i], i) || prev != first) {
            int turn = i / n + 1;   // 몇 번째 턴인지 계산
            int player = i % n + 1; // 몇 번째 사람이 틀렸는지 계산
            answer[0] = player;
            answer[1] = turn;
            return answer;
        }
    }

    return answer; // 아무도 틀리지 않았으면 [0, 0] 반환
}

