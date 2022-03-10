#include <iostream>
#include <string>

using namespace std;

int main(){
    string str ;
    cin>>str;
    int mid = str.size()/2;
    if(str.size()%2!=0) str.erase(str.begin()+ mid);//홀수면 짝수로 만들고 확인한다

    for(int i = 0 ; i<mid ; i++)
    {
        if(mid-i-1<0||mid+i>str.size())break;
        if(str.at(mid-i-1)==str.at(mid+i))continue;
        else 
        {
            cout<<0;
            return 0;
        }
    }
     cout<<1;
}