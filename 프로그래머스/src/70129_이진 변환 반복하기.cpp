// https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=cpp
#include <string>
#include <vector>
#include <iostream>

using namespace std;

int countZero(string s) {
    int zeros = 0;
    for (auto i : s) {
        if (i=='0') zeros++;
    }
    // cout << "zero # : " << zeros;
    return zeros;
}

// convert length to binary
string to_binary(int len) {
    string tobin ="";
    int weight = 1;
    while(len>1) {
        if (len%2 == 0)  {
            tobin.append("0");
        } else { 
            tobin.append("1");
        };
        len /=2;
    }
    
    tobin += (len==1) ? "1" : "0";
    
    // Reverse it
    string returnval ="";
    for(int i = tobin.size()-1 ; i>=0; i--) {
        returnval+=(tobin[i]);
    }
    
//     cout << "bin " << tobin <<endl;
//     cout << "reversed : " << returnval <<endl;
    return returnval;
}

vector<int> solution(string s) {
    vector<int> answer;
    // 0 을 제거. -> 길이를 이진수로 변환하는 것
    int bincount = 0;
    int zerocount = 0;
    while(s!="1") {
        // end case
        int sLen = s.size();
        int zeros = countZero(s);
        // cout << "while len : " << (sLen-zeros) << endl;
        s = to_binary((sLen-zeros));
        bincount++; // 이진 변환의 수
        zerocount += zeros;
    }
    
    answer.push_back(bincount);
    answer.push_back(zerocount);
    return answer;
}
