#include <vector>
#include <iostream>
#include <string>

using namespace std;

int main()
{
    vector<int> dices(7,0);
    int a,b,c;
    cin>>a>>b>>c;
    
    dices[a]++;
    dices[b]++;
    dices[c]++;

    int maxCnt = 0;//가장 많이 나온 빈도
    int maxCntNum = 0;//가장 큰 눈금

    for(int i = 0 ; i<dices.size() ; i++)
    {
        if(dices[i]>=maxCnt)
        {
            maxCnt = dices[i];
            maxCntNum = i;
        }
    }
    if(maxCnt==3) cout<<(10000+(1000*maxCntNum))<<endl;
    else if(maxCnt == 2) cout<<(1000 +(maxCntNum*100))<<endl;
    else cout<<(maxCntNum*100)<<endl;
}