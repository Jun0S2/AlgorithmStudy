#include <iostream>
#include <vector>
#include <stack>

using namespace std; 

int main() {
  string input ; 
  cin>>input;
  //input의 사이즈 만큼 백터에 담기
  
  char start = 'a';
  vector<char> alphabets(input.size());
  stack<char> st;
  for(int i = 0 ; i<input.size() ; i++)alphabets[i] = start+i;
  
  //init
  int index = 0 , pointer = 0;
  string answer ="";
 
  while(pointer<input.size())
  {
    if(st.empty())
    {
      st.push(alphabets[index++]);
      answer += "push\n";
     
    }
    else if(st.top() == input[pointer])
    {
      answer +="pop\n";
      st.pop();
      pointer++;
    }
    else
    {
      st.push(alphabets[index++]);
      answer +="push\n";
    }
  }
//  cout<<st.size();
  if(st.empty()){cout<<answer;}
  else cout<<"impossible";
  return 0;
}
