#include <iostream>
#include <string>

using namespace std;

int main(){
    int N;
    string str;
    cin>>N;
    int cnt = 0;
    for(int i = 0 ; i<N ; i++)
    {
        cin>>str;
        if(str.length()%2!=0)continue;//짝지을 수 없음
        else if (str.length()==2)
        {
            if(str[0]==str[1]){cnt++; continue;}
            else continue;
        }
        for(int i = 0 ; i<str.size()-1 ; i++)
        {
            if(str[i]==str[i+1])
            {
                str.erase(str.begin()+i+1) ;
                str.erase(str.begin()+i) ;
                i = 0;
            }
        }
        if(str.size()==1)cnt++;
        else if(str[0]==str[1] && str.size()==2)cnt++;
       // cout<<str<<endl;
    }
    //cout<<"answer : "<<cnt<<endl;
    cout<<cnt;
}