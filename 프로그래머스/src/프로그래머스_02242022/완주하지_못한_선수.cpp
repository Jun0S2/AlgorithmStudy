#include <string>
#include <vector>

using namespace std;
//erase 를 쓰니 효율성 테스트를 탈탈 털렸다..
string solution(vector<string> participant, vector<string> completion) {
vector<string> s;
    for(auto p : participant) s.push_back(p);
   // for(auto c : completion) {s.erase(c);}  erase 와 remove를 같이 쓰려면 알고리즘이 필요하니..erase만..
    for(int i = 0 ; i < completion.size() ; i ++)
    {
        for(int j = 0 ; j < s.size() ; j ++)
        {
            if(completion[i]==s[j])
            {
                s.erase(s.begin()+j);//아니 왜 여기에 s.begin이 들어가는데용..
                break;
            }
        }
    }
    
    return s[0];
}