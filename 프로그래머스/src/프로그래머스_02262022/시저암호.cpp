#include <string>
#include <vector>

using namespace std;
// A : 65, a : 97 Z = 65+26 = 90 z = 97+26-1 = 122
string solution(string s, int n)
{
    string answer = "";

    for (int i = 0; i < s.size(); i++)
    {

        int current = s.at(i) + n;

        if (current - n == 32)
            answer += " "; //공백일 경우
        else               //문자일 경우
        {
            if (s.at(i) <= 122 && s.at(i) >= 97 && current <= 122 && current >= 97 || s.at(i) <= 90 && s.at(i) >= 65 && current <= 90 && current >= 65)
                answer += (char)current; //+n한 ascii가 문자인 경우
            else
                answer += (char)(current - 26); //알파벳이 아니게 된 경우 -26 (A부터 롤백)
        }
    }
    return answer;
}