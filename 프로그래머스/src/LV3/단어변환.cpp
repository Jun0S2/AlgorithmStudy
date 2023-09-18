#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

bool compareWords(string word1, string word2) {
    int temp = 0;
    for(auto i = 0 ; i<word1.size() ; i++) {
        if(word1[i]!=word2[i]) temp++;
    }
    return ((temp>1)?false:true);
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    bool visited[50];
 
    // Case 1 : target 이 없는 경우
    if (find(words.begin(), words.end(), target) == words.end() ) {
        return 0;
    }
    
    queue<pair<int,string>> q;
    q.push({0,begin});
    
    while(!q.empty()) {
        int cnt = q.front().first;
        string compare = q.front().second;
        q.pop();
        
        for(auto i = 0 ; i < words.size(); i++) { // compare word
            if(compareWords(compare,words[i])) {
                if (words[i] == target) { // 도달 완료
                    return answer = cnt +1;
                }
                q.push({cnt+1,words[i]});
                visited[i] = true;
            }
        }
    }
    
    return answer;
}
