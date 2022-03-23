#include <iostream>
#include <string>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int title = 665;
    int cnt = 0;
    string tostr;

    while (++title)
    {
        tostr = to_string(title);
        if (tostr.find("666") != -1) // 찾음
        {
            ++cnt;
        }
        if (cnt == n)
        {
            cout << title << endl;
            break;
        }
    }
}