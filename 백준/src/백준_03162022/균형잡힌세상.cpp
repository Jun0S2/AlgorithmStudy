#include <iostream>
#include <stack>
#include <string>

using namespace std;

string input ="";

int main(){
    ios::sync_with_stdio(0);
	cin.tie(0);
    
	while(input!=".")
    {
        getline(cin, input);
        if(input ==".")break;
        bool answer = true;
        stack<char>p;

        for(char &c : input)
        {
            if(c=='('||c=='[') p.push(c);
            else if (c==')')
            {
                if(p.empty()) {answer = false; break;}
                else if (p.top() !='(') {answer = false; break;}///[가 top에 있으면 매칭x
                else p.pop();
            }
            else if (c==']')
            {
                if(p.empty()) {answer = false; break;}
                else if (p.top() !='[') {answer = false; break;}///[가 top에 있으면 매칭x
                else p.pop();
            }
        }
        if(!p.empty()) answer = false; // ex ; ((([ 만 남은 경우
        if(answer)cout<<"yes\n";
        else cout<<"no\n";
    }
}