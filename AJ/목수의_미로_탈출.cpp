#include <iostream>
#include <vector>
#include <queue>
#include <limits.h>

using namespace std;

int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};
int N,M;
int start_x, start_y, end_x, end_y;
int answer = INT_MAX; //최소거리
vector<vector<vector<bool> > > visited;
vector<vector<int>> map;


struct Node{
  int x, y, distance;
  bool isBroken;
  
  Node(int _x,int _y, bool _isBroken, int _distance){
    x = _x;
    y = _y;
    isBroken = _isBroken;
    distance = _distance;
  }
  
};

struct compare //우선순위큐 비교용
{
  bool operator()(Node &n1, Node &n2) 
  {
    return n1.distance > n2.distance ;
  }
  
};

/**
 * init() : 초기화 함수
 * start x , start_y : N-1 , 0에서 출발
 * end_x, end_y : 0,M-1 까지 이동
*/
void init(){
  
  start_x = N-1;
  start_y = 0;
  end_x = 0;
  end_y = M-1;
  
  //벡터 리사이징
  map.resize(N,vector<int>(M));
  visited.resize(N);
  for (int i = 0; i < N ; i++)
  {
    visited[i].resize(M+1);
    for (int j = 0; j < M; j++)
    {
      visited[i][j].resize(2);
    }
  }
}

/**
 * bfs를 사용하여 이동 
 * 
 */
void bfs(){
  priority_queue<Node, vector<Node>, compare> q;
  q.push(Node(start_x, start_y, false, 0));
  while(!q.empty())
  {
    Node node = q.top();
   // cout<<q.size()<<endl;
    q.pop();
    if(node.x == end_x && node.y == end_y)  //도착 
    {
     // cout<<node.distance<<endl;
      answer = node.distance; 
      break;
    }
    
    for(int d = 0 ; d<4 ; d++)
    {
      int nx = node.x + dx[d];
      int ny = node.y + dy[d];
      
     if(nx<0||ny<0||nx>=N||ny>=M) continue;//out of range
     if(map[nx][ny] == 0 && !visited[nx][ny][node.isBroken])
     {
       q.push(Node(nx,ny,node.isBroken, node.distance+1));
       visited[nx][ny][node.isBroken] = true;
     }
     else if(!node.isBroken && map[nx][ny]==1 && !visited[nx][ny][1])
     {
        q.push(Node(nx,ny,true, node.distance+1));
        visited[nx][ny][1] = true;
     }
    }
    
    
  }
}

int main() {
  
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin>>N>>M;
  init();

  for(int i = 0 ; i<N ; i++)
  {
    for(int j = 0 ; j<M ; j++)
    {
      cin>>map[i][j];
    }
  }
  
  bfs();
 
  if(answer == INT_MAX)
  {
    cout<<"항상 탈출할 수 있기 때문에 이 조건엔 오면 안됀다.";
  }
  else cout<<answer;
  return 0;
}

