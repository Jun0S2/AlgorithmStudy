#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    string str ;
    cin>>str;
    //1.정렬
    sort(str.begin(),str.end());
   
    //2.짝수판별~
    string first_half;
    string div="";
    bool one = false;
    bool fail = false;
    for(int i = 0 ; i<str.length() ; i++)
    {
        if(str[i]==str[i+1]) {first_half +=str[i]; ++i;}
        else if(!one){one = true; div = str[i];}
        else {fail = true; break;}
    }
    if(!fail)
    {
        cout<<first_half;
        if(one)cout<<div;
        for(int i = first_half.size()-1 ; i>=0;i--)cout<<first_half[i];
    }
    else cout<<"I'm Sorry Hansoo"<<endl;
}