#include <iostream>
#include <vector>

using namespace std;
int main()
{
    vector<int> count(100, 0); // 1 ~ 100
    int inputSize = 0;
    for (auto i = 0; i++; i < inputSize)
    {
        int num;
        cin >> num;
        count[num]++;
    }
    int chosen;
    cin >> chosen;
    cout << count[chosen] << endl;

    return 0;
}