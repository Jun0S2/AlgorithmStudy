#include <string>
#include <vector>

using namespace std;

const vector<int> month = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
const vector<int> date = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
const vector<string> day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}; //금요일부터 시작

string solution(int a, int b)
{
    // 1월 1일이 금요일
    // step 1 : 총 날짜 계산
    int d = 0;
    for (int i = 1; i <= a; i++)
    {
        if (i == a)
            d += b;
        else
            d += date[i];
    }
    // step 2 : 7로 나누어서 요일 파악-> 1월 1일을 기준으로

    string answer = day[d % 7];
    return answer;
}