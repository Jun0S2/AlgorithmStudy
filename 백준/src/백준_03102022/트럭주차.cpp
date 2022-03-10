#include <vector>
#include <string>
#include <iostream>

using namespace std;

int A,B,C;//요금
vector<int> time(101,0);//각 시간 당 주차된 차의 수

int main(){
    int start,end;
    cin>>A>>B>>C;
    B *= 2;
    C *= 3;

    for(int t = 0 ; t<3 ; t++)
    {
        cin>>start>>end;
        for(int i = start ; i<end ; i++)
        {
            time[i]++;
        }
    }

    int cost=0;
    for(int i = 1 ; i<=100 ; i++)
    {
        if (time[i]==1) cost += A;
        else if (time[i]==2) cost += B;
        else if (time[i]==3) cost += C;
    }

    cout<<cost;
}