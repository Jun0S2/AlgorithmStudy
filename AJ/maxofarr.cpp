#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  vector<int>max = {-1,-1,-1}; //max,x,y  
  
  int input = 0;
  
  for(int i = 0 ; i < 9 ; i++ )
  {
    for(int j = 0; j< 9 ; j++)
    {
        cin >> input;
        if(input>max[0])
        {
          max[0] = input;
          max[1] = i+1;
          max[2] = j+1;
        }
    }
  }
  cout<<max[0]<<endl<<max[1]<<" "<<max[2];
  return 0;
}
