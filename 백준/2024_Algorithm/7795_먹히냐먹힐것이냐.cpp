#include <algorithm>
#include <iostream>
#include <vector>

/**
 * @date 2024.09.19
 * @author June Park
 * Sorting 문제
 */
using namespace std;
vector<int> vec_A;
vector<int> vec_B;
int main()
{
    int T, A, B;
    cin >> T; // TC
    for (int i = 0; i < T; i++)
    {
        cin >> A >> B;
        vec_A.resize(A);
        vec_B.resize(B);
        for (int j = 0; j < A; j++)
        {
            cin >> vec_A[j];
        }
        for (int j = 0; j < B; j++)
        {
            cin >> vec_B[j];
        }
        sort(vec_A.begin(), vec_A.end());
        sort(vec_B.begin(), vec_B.end());

        int answer = 0;
        for (auto a : vec_A)
        {
            int index = 0;
            while (index < B) // find end point index
            {
                if (vec_B[index] < a)
                {
                    answer++;
                    index++;
                }
                else
                {
                    break;
                }
            }
        }
        cout << answer << "\n";
    }
}