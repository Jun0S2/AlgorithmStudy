#include <string>
#include <vector>

using namespace std;

string solution(string s)
{
    string answer = "";
    int cnt = 0;
    for (int i = 0; i < s.size(); i++)
    {
        if (s.at(i) == ' ')
            cnt = 1;
        if (cnt % 2 == 0)
            answer += toupper(s.at(i));
        else
            answer += tolower(s.at(i));
        cnt++;
    }
    return answer;
}