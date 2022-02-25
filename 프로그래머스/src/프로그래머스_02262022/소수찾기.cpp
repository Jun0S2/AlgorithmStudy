#include <string>
#include <vector>

using namespace std;

//미리 처음에 구해놓으까?
vector<bool> isPrime(10000000, true);
int solution(int n)
{
    // false : 소수, true : 소수가 아님
    for (int i = 2; i * i < 1000000; i++)
    {
        if (isPrime[i]) //소수인 수 발견 -> 이제 이 숫자의
            for (int j = i * i; j <= 1000000; j += i)
            {
                isPrime[j] = false;
            }
    }

    int cnt = 0;

    for (int i = 2; i <= n; i++)
    {
        if (isPrime[i])
            cnt++;
    }
    return cnt;
}