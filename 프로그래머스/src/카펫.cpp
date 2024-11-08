#include <string>
#include <vector>
#include <iostream>
using namespace std;
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
vector<int> brute_force(int size, int brown) {
    vector<int> answer = {0,0};
    for (int i = 1; i <size/2 ; i++) {
        int width = i;
        int height = size/i;
        if(size%i==0) {
            if(width>height) break;
            // 테두리 한줄은 갈색임 -> (width + height) *2 - 4 = brown 이여야함
            if(((width+height)*2-4) == brown) {
                answer[0] = height;
                answer[1] = width;
            }
        } 
    }
    return answer;
}
vector<int> solution(int brown, int yellow) {
    return brute_force(brown+yellow,brown);
}
