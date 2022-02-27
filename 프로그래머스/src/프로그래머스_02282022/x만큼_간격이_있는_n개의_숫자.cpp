#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    answer.emplace_back(x);
    for(int i = 2; i<= n ; i++) answer.emplace_back(x+answer.back());
    return answer;
}