#include <string>
#include <vector>

using namespace std;

string solution(int n)
{
    string answer = "";
    vector<string> melon = {"수", "박"};
    for (int i = 0; i < n; i++)
    {
        answer += melon[i % 2];
    }
    return answer;
}