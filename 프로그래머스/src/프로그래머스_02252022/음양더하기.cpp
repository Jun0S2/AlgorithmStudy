#include <string>
#include <vector>

using namespace std;

/*true : 양수, false : 음수*/
int solution(vector<int> absolutes, vector<bool> signs)
{
    int answer = 0;
    for (int i = 0; i < signs.size(); i++)
    {
        if (signs[i])
            answer += absolutes[i];
        else
            answer -= absolutes[i];
    }

    return answer;
}