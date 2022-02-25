#include <vector>

using namespace std;

vector<int> solution(vector<int> arr)
{
    vector<int> answer;
    //연속만 아니면 됌 -> peek
    for (auto a : arr)
    {
        if (!answer.empty() & answer.back() == a)
            continue;
        else
            answer.push_back(a);
    }

    return answer;
}