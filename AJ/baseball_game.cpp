#include <iostream>
#include <vector>
//#include <string> //tostring

using namespace std;

struct Baseball{
  int guess;
  int strike;
  int ball;
};

int N;
vector<Baseball> input;


int main() {

  ios::sync_with_stdio(0);
  cin.tie(0);
  
  cin>>N;
  int n,s,b;
  
  for(int i = 0 ; i<N ; i++)
  {
    cin>>n>>s>>b;
    input.push_back({n,s,b});
  }

int answer=0;

  for(int i = 1; i<=9 ; i++)
  {
    for(int j =1 ; j<= 9 ; j++)
    {
      for(int k = 1 ; k<=9 ;  k++)
      {
          bool flag = false;
        if(i!=j && j!=k && i!=k)
        {
          for(int p = 0 ; p<N; p++)
          {
            int first  = input[p].guess / 100;
            int second = (input[p].guess / 10) %10;
            int third = input[p].guess %10;
            
          
            int st = 0, ba = 0;
            if(first == i )st++;
            if(second ==j)st++;
            if(third == k)st++;
            
            if(i==second||i==third)ba++;
            if(j==first||j==third)ba++;
            if(k==second||k==first)ba++;
            
            if(input[p].strike != st || input[p].ball != ba) flag = true;
            
          }
          if(!flag)
          { 
            answer++;
          //  cout<<i<<j<<k<<endl;
            
          }
        }
      }
    }
  }
  cout<<answer;
  
  return 0;
}
