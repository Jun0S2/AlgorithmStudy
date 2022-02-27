#include <string>
#include <vector>

using namespace std;
//긴 변 * 짧은 변
int solution(vector<vector<int>> sizes) {
    int left = 0;
    int right = 0;
    
    for(int i = 0 ; i<sizes.size() ; i++)
    {
        int min = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
        int max = sizes[i][0] >= sizes[i][1] ? sizes[i][0] : sizes[i][1];
        left = left > max ? left : max;
        right = right > min ? right : min;
    }
    return right * left ;
}