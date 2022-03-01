#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(){
    int H,M,T;
    cin>>H>>M>>T;
    int plus_hour = 0;
    if(M+T>=60) 
    {
        int temp = M+T;
        while(temp>59)
        {
            plus_hour++;
            temp-=60;
        }
        M = temp;
    }
    else M += T;

    if(plus_hour>0)
    {
        H+=plus_hour;
        if(H>=24) H-=24;
    }

    cout<<H<<" "<<M<<endl;
}