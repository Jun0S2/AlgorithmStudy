#include <iostream>
#include <string>

using namespace std;

int main(){
    string str,check ;
    string start,end;//*로 나누기
    int N;
    cin>>N>>str;

    bool split = false;
    for(char &c : str)
    {
        if(c=='*')split = true;
        else if (!split) start +=c;
        else end +=c;
    }

    for(int i = 0 ; i<N ; i++)
    {
        cin>>check;
        //모든 문자열에서 start와 end찾기
        bool flag = false;
        int index = 0;
        for(int i = 0 ; i<start.length() ; i++)
        {
            if(check.length()==0){flag=true;break;}
            if(start[i]==check[i-index]){check.erase(check.begin()+i-index); index++;}
            else {flag=true;break;}
        }
        for(int j = end.length()-1 ;j>=0 ;j--)
        {
            if(check.length()==0){flag=true;break;}
            if(end[j]==check[check.length()-1])//마지막 같은가?
            {
                check.pop_back();
            }b
            else {flag = true; break;}
        }
        if(flag)cout<<"NE"<<endl;
        else cout<<"DA"<<endl;
       //cout<<check<<endl;
        
    }

}