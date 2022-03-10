#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    long long N,M;
    long long cnt = 0;
    vector<long long>fe;
    cin>>N>>M;
    long long input = 0;
    for(int i = 0 ; i<N ; i++)
    {
        cin>>input;
        long long target =  M - input;
        if(fe.empty())fe.push_back(target);
        else //fe에 있나 찾아본다!
        {
            bool found = false;
          //시간초과날거같은데..min heap써서 항상 정렬되면 컷하기 편할텐데
          for(int j = 0 ; j<fe.size() ;j ++)
          {
              if(fe[j]==input)//찾을 땐 원본값으로
              {
                  fe.erase(fe.begin()+j);
                  found = true;
                  cnt++;
                  break;
              }
          }
          if(!found) fe.push_back(target);//fe에 넣을 땐 adjusted값으로
        }
    }
    cout<<cnt;
}