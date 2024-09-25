// https://school.programmers.co.kr/learn/courses/30/lessons/12924
#include <string>
#include <vector>
#include <iostream>

using namespace std;
// 투포인터 ?
// 연속되어야하니까..
int solution(int n) {
    int answer = 1;
    vector<int> numbers(n+1,0);
    for (int i = 1 ; i<=n ; i++ ) {numbers[i] = i;}
    
    int sum = 0; // itself
    
    for (int i = 1; i<= n ; i++) {       // ptr1
        sum = numbers[i];             // 첫번째 숫자
        // cout <<" +=+_+_+_++_+_+_" <<endl;
        // cout << "Reset Sum : " << sum << endl;
        
        for (int j = i+1; j <=n ; j++ ) {  // ptr2
            sum += numbers[j];
            // cout << "sum : " << sum <<endl;
            if (sum == n) {
                // cout << "Found it : accu sum" << sum <<endl; 
                answer++;
                break;
            }
            if (sum > n) break;
        }
    }
    
    return answer;
}
