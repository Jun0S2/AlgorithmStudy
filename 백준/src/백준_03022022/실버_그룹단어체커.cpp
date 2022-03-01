#include <string>
#include <iostream>
#include <vector>

using namespace std;

//결국 if 단어 already exists -> false unless it was right before
int main(){
    int N;
    string input;
    int answer = 0;
    cin>>N;

    for(int i = 0 ; i<N ; i++)
    {
        cin>>input;
        vector<char> exists; //이미 나온 글자 저장
        char prev = input[0];//첫글자
        exists.push_back(prev);
        bool group = true;

        for(int i = 1 ; i<input.size() ;i ++)
        {
            if(input[i]==prev)continue;
            else
            {
                for(char c : exists) if(c==input[i]) {group = false; break;}
                prev = input[i]; //break문에 걸리지 않았다면, 새 prev로 지정
                exists.push_back(input[i]);
            }
        }
        
        answer += (group) ? 1 : 0;        
        exists.clear();
    }
    cout<<answer;
}