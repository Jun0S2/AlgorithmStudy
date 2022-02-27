#include <string>
#include <vector>

/* 유클리드 호제*/
using namespace std;

vector<int> gcd(int N, int M)
{
    long long lcd = (long long )N * (long long) M;
    int left ;
    while(M!=0)
    {
        left = N % M;
        N = M;
        M = left;
    }
    return {N,  (int)lcd/N};
}
vector<int> solution(int n, int m) {
    return gcd(n,m);
}