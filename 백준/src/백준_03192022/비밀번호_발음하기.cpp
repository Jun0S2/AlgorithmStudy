#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<char> vowel = {'a', 'e', 'i', 'o', 'u'};
/*모음이 한개 이상*/
bool step1(string str)
{
    for (auto &c : str)
    {
        for (auto &v : vowel)
            if (c == v)
                return true;
    }

    return false;
}

/*모음이 3개 혹은 자음이 3개 연속으로 오면 false*/
/*모음 카운터*/
bool step2_1(string str)
{
    int vowelCnt;
    bool cons = false;

    bool find = false;
    for (int i = 0; i < str.size(); i++)
    {
        find = false;
        for (int j = 0; j < 5; j++)
        {
            if (str[i] == vowel[j])
            {
                if (i == 0)
                {
                    vowelCnt++;
                }
                else if (str[i - 1] == 'a' || 'e' || 'i' || 'o' || 'u') //연속
                    vowelCnt++;
                if (vowelCnt >= 3)
                    return false;
                find = true;
                break;
            }
        }
        if (!find)
            vowelCnt = 0;
    }
    return true;
}
/*자음 카운터*/
bool step2_2(string str)
{
    int consonantCnt = 0;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    string input;

    while (true)
    {
        cin >> input;
        if (input == "end")
            break;

        if (!step1(input))
        {
            cout << "fail" << endl;
            continue;
        }

        if (!step2_1(input))
        {
            cout << "so many vowels" << endl;
            continue;
        }
    }
}