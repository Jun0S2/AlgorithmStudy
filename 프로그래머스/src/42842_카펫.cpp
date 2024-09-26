#include <string>
#include <vector>
#include <iostream>
using namespace std;
//https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=cpp
vector<int> solution(int brown, int yellow) {
    vector<vector<int>> answer;
    int size_ = brown + yellow;
    // 12 -> {1,12}, {2,6} , {3,4} / 반복. {4,3} , {6,2},
    // 중 한개.
    // 가로가 더 길다. 그러면 세로, 가로으 ㅣ조합
    // return 은 size_ 가 나오는 조합 중 하나임.
    // 근데 테두리가 있으니까.. 1 은 나올 수가 없고.. 더해서 홀수면 곤란하지..격자니까..
    // 2~ 반까지
    
    for (int i = 2 ; i<(size_/2); i++) {
        for (int j = (size_/2) ; j>=i; j--) {
            if(i*j == size_) {
                if (2 * j + 2 * i - 4 == brown) { return {j, i};}
            }
        }
    }
    // 이제 백터에 대해서 넓이를 구해야함..
    // 10 개 2개를 봣다고 한다면...
    // 가로 * 2 + (가로-세로)*2
    // 16 + 4 = 20 ..?
    // for (auto x : answer) {
    //     int width = x[1];
    //     int height = x[0];
    //     if (2 * width + 2 * height - 4 == brown) {
    //         return {width, height};
    //     }
    // }
    // 시간초과 -> 아에 루프 안에 넣기

    
    
    return {};
}
