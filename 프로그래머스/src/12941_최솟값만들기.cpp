#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// https://school.programmers.co.kr/learn/courses/30/lessons/12941
// 최소값 : 최소 * 최대
int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    // A는 오름차순으로 정렬
    sort(A.begin(), A.end());

    // B는 내림차순으로 정렬
    sort(B.begin(), B.end(), greater<int>());

    // A의 작은 값과 B의 큰 값을 곱해서 최소값을 얻음
    for (int i = 0; i < A.size(); i++) {
        answer += A[i] * B[i];
    }

    return answer;
}
