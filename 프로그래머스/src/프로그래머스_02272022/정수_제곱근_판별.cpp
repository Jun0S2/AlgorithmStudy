#include <string>
#include <vector>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<long long> squared(7000000);
    for(long long i = 1 ; i< 7000000; i ++)
    {
        squared[i] = i*i;
    }
 
    int index = 0;
    
    for(long long i = 1;  i < squared.size() ; i ++ )
    {
        if( squared[i] == n )
        {
            index = i;
            break;
        }
        if(squared[i] > n) break;
    }
    
    if(index==0)return -1;
    else return squared[index+1];
    
}