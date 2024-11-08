#include <string>
#include <vector>
// https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=cpp
using namespace std;

// 1번쨰 : 1,2,3,4,5
// 2번째 : 2, 1, 2, 3, 2, 4, 2, 5
// 3번째 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
int solved(int answer, vector<int>& student, int number) {
    int index = number % student.size();
    return answer == student[index] ? 1 : 0;
}

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> A = {1, 2, 3, 4, 5};
    vector<int> B = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
   vector<int> scores(3, 0);
    for(int i = 0; i < answers.size(); i++) {
        int ans = answers[i];
        scores[0]+=solved(ans,A, i);
        scores[1]+=solved(ans,B, i);
        scores[2]+=solved(ans,C, i);
    }
    
    int maxScore = max(scores[0], max(scores[1], scores[2]));

    for (int i = 0 ; i < 3 ; i++) {
        if (scores[i] == maxScore) answer.push_back(i + 1);
    }
    
    return answer;
}
