#include <iostream>
#include <vector>
#include <string>

using namespace std;

string input ="";

/*.과 " " 그리고 글자를 없애는 함수*/
void removeLetters(){
    string strCopy = input;
    input = "";
    for(int i = 0 ; i<strCopy.size() ; i++)
    {
        if(strCopy[i]=='('||strCopy[i]==')'||strCopy[i]=='['||strCopy[i]==']')
        {
            input.push_back(strCopy[i]);
        }
    }

}
/* [] 와 () 가 같이 있어서 생각처럼 작동하지 않았다
bool isPalindrome(){
    
    int pCnt = 0; //( ++ )--
    int spCnt = 0; //[ ++ ] --

    for(int i = 0 ; i<input.size() ;i ++)
    {
        //합 
        if(input[i]=='(') pCnt++;
        else if (input[i]==')')  pCnt--;
        else if(input[i]=='[') spCnt++;
        else spCnt--;

        if(pCnt<0||spCnt<0) return false;//만약 ] 나 )가 더 많으면 false
    }

    if(pCnt==0 && spCnt ==0) return true;
    else return true;
}*/


bool isPalindrome(){
    if(input.size()==0) return true;
    if(input.size()%2!=0)return false;
    char open ,close;
    int index = 1;
    int pCnt = 0;
    int spCnt = 0;
    while(input.size()>0)
    {
        open = input[0];
        if(open==']'||open==')')return false;

        cout<<"letters : "<<input<<endl;
        
        if(open =='[' && input[index]=='(')pCnt++;
        else if (open =='(' && input[index]=='[') spCnt++;
        else if(open == '(' && input[index]==']' && spCnt==0) return false;
        else if(open == '[' && input[index] == ')' && pCnt==0) return false;
        else//found matching par
        {
            input.erase(input.begin());
            input.erase(input.begin()+index);
            cout<<"adjusted : "<<input<<endl;
            index = 1;//다시 초기화
        }
        index++;
    }
    return true;
}

int main(){
    ios::sync_with_stdio(0);
	cin.tie(0);
	while(input!=".")
    {
        getline(cin, input);
        if(input ==".")break;
        removeLetters();
        if(isPalindrome()) cout<<"yes\n";
        else cout<<"no\n";
    }
}