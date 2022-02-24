#include <string>
#include <vector>
#include <unordered_map>

using namespace std;
//erase 를 쓰니 효율성 테스트를 탈탈 털렸당 ^.^
string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int>name_list; //맵 - 이름, cnt (동명이인때문,,)
    for(auto p : participant) name_list[p] +=1;
    for(auto c : completion) name_list[c]-=1;
   
    //cnt가 1인 선수 return
    for(auto m : name_list) if(m.second>0) return m.first;
}