// https://school.programmers.co.kr/learn/courses/30/lessons/12911
#include <string>
#include <vector>
#include <iostream>

using namespace std;

int countOnes(string binar) {
    int ones = 0;
    for (auto c : binar) {
        if (c=='1') ones++;
    }
    return ones;
}

string to_binary(int n) {
    int weight = 2;
    string ans="";
    while (n>1) {
        if (n%2==0) ans += "0";
        else ans+="1";
        n /= 2;
    }
    
    if (n==1) {
        ans +="1";
    } else {
        ans +="0";
    }
    
    // reverse it
    string ret ="";
    for (int i = ans.size()-1; i>=0; i--) {
        ret += ans[i];
    }
    return ret;
}

int solution(int n) {
    int answer = n+1;
    // to binary
    string input = to_binary(n);
    int goal = countOnes(input);
    // cout << input << " : " << goal << endl;
    
    while (true) {
        int count = countOnes(to_binary(answer));
        if (count == goal) break;
        answer++;
    }
    return answer;
}
