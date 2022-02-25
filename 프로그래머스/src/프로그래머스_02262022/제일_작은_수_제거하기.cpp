#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<int> arr)
{
    vector<int> answer;
    int min = -1;
    if (arr.size() == 1)
        return {-1};
    //간단하니까 algorithm header 없이 진행
    for (auto i : arr)
        min = min < i && min > 0 ? min : i;
    for (auto i : arr)
        if (i != min)
            answer.emplace_back(i);
    return answer;
}