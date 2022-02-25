#include <string>
#include <vector>

using namespace std;

string solution(string s)
{
    string answer = "";
    int mid = s.size() / 2 - 1;
    if (s.size() == 1)
        return s;
    if (s.size() % 2 == 0)
        answer = s.substr(mid, 2);
    else
        answer = s.at(mid + 1);

    return answer;
}