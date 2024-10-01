// https://school.programmers.co.kr/learn/courses/30/lessons/84512
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> wordlist;
vector<char> arr = {'A', 'E', 'I', 'O', 'U'};
string strKey;

// DFS를 이용해 모든 가능한 단어 조합을 생성
void dfs(int depth, string selected) {
    if (depth > 5) return; // 단어의 길이가 5를 넘으면 종료
    wordlist.push_back(selected); // 현재까지 선택된 단어를 리스트에 추가
    for (int i = 0; i < 5; i++) {
        dfs(depth + 1, selected + arr[i]); // 다음 단어로 이동
    }
}

int solution(string word) {
    strKey = word;
    dfs(0, "");
    sort(wordlist.begin(), wordlist.end());
    auto it = find(wordlist.begin(), wordlist.end(), strKey); // 순서 찾기
    return distance(wordlist.begin(), it);
}
