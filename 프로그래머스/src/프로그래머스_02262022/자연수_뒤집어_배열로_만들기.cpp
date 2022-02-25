#include <string>
#include <vector>

using namespace std;

vector<int> solution(long long n)
{
    vector<int> answer;
    string itos = to_string(n);

    for (int i = itos.size() - 1; i >= 0; i--)
        answer.emplace_back(itos.at(i) - '0');
    return answer;
}