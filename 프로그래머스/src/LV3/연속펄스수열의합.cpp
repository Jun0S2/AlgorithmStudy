#include <string>
#include <vector>

using namespace std;

/**
*  purse 수열 ? a b c 를 a -b +c 나 -a +b -c
*  Case 1 : +a -b +c
*  Case 2 : -a +b -c = -(-a) -(-b) -(+c)
*  -> 일단 1 -1 1 -1 곱한 다음에 계산
*/

auto compare_ll = [](const long long l1, const long long l2) {
                   if (l1 < l2) return l2;
                   else return l1;
}; // return greater value

long long solution(vector<int> sequence) {
    long long answer = 0; 
    // step 1 : -1 곱함.
    for(auto i = 0 ; i < sequence.size() ; i++) {
        if((i%2)!=0) { 
            sequence[i] *= -1;
        }
    }
    //  Case 1 : +a -b +c
    auto add = [&]() {
        long long ret = 0;
        long long sum = 0;
        for(auto i = 0 ; i < sequence.size() ; i++) {
            sum = compare_ll(sum,0) + sequence[i]; // 이전까지 합 vs 새로 시작 + current number
            ret = compare_ll(ret, sum); // 이전 vs curr 
        }
        return ret;
    };
    //  Case 2 : -a +b -c = -(-a) -(-b) -(+c)
    auto sub = [&]() {
        long long ret = 0;
        long long sum = 0;
        for(auto i = 0 ; i < sequence.size() ; i++) {
            sum = compare_ll(sum,0) - sequence[i];
            ret = compare_ll(ret, sum);
        }
        return ret;
    };

    answer = compare_ll(add(), sub()); // Case 1 vs Case 2 값 비교하여 리
    return answer;
}
