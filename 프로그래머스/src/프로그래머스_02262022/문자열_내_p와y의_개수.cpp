#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int pNum = 0;
    int yNum = 0;

    for (int i = 0; i < s.size(); i++)
    {
        if (s.at(i) == 'P' || s.at(i) == 'p')
            pNum++;
        else if (s.at(i) == 'Y' || s.at(i) == 'y')
            yNum++;
    }

    return pNum == yNum ? true : false;
}