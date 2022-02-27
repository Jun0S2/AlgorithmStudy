#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
  vector<int> vec;
  while(n>=1)
  {
      vec.push_back(n%3);
      n/=3;
  }
    
   // for(auto i : vec)cout<<i<<" ";
   //  cout<<endl;
    
    int answer = 0;
    int tri = 1;
    
    for(int i = vec.size()-1 ; i>=0 ; i--)
    {
        answer += tri*vec[i];
        tri *=  3;
    }
    return answer;
   
}