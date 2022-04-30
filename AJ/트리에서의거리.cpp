#include <iostream>
#include <vector>

using namespace std;

int N, X,Y;

vector<int> parent;
vector<int> visitedX;
vector<int> visitedY;


int main() {
  cin>>N>>X>>Y;
  parent.resize(N);
  visitedX.resize(N, -1); //미쳤나봐.. int인데..
  visitedY.resize(N , -1);
  
  int a, b;  //간선정보 a,b연결됨
  
  for(int i = 0 ; i< N ; i++)
  {
    cin>>a>>b ;
    parent[b] = a;// node a -> node b
  }
  
  int cnt = 0, sum = 0;
  while(true)
  {
    visitedX[X] = cnt++;
    if(X==0)break;
    X = parent[X];
  }
//  cout<<X<<endl;
  cnt = 0;//reset
  
  while(true)
  {
    if(visitedX[Y]!=-1)
    {
      cout<<visitedX[Y] + cnt;
      return 0;
    }
    else
    {
      visitedY[Y] = cnt++;
      if(Y == 0)break;
      Y = parent[Y];
    }
  }
  
 cout<<sum<<endl;
  
  return 0;
}
