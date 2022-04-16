#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack<char> st;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  string str;
  cin>>str;
  
  int answer = 0, val = 1;
  
  for(int i = 0 ; i<str.size() ; i++ )
  {
    /* ( 나 [ 인 경우 스택에 push & val에 값 곱함*/
    if(str[i]=='(')
    {
      st.push('(');
      val *= 2;
    }
    else if(str[i]=='[')
    {
      st.push('[');
      val *= 3;
    }
    /* ) 인 경우 */
    else if (str[i]==')')
    {
      /*stack==empty || peek가 ( 가 아니면 올바른 괄호가 아님 */
      if(st.empty() || st.top()!='(')
      {
        answer = 0;
        break;
      }
      /* 이전문자열 ( 이면 val을 answer에 더하고 val은 원래대로 돌려놓기*/
      else if (str[i-1]=='(')
      {
        answer +=  val;
        val /= 2;
        st.pop();
      }
      else//이미 answer에 더해짐 
      {
        val /=2;
        st.pop();
      }
    }
    /* ] 인 경우 : )와 동일 */
    else if (str[i]==']')
    {
      if(st.empty() || st.top()!='[')
      {
        answer = 0;
        break;
      }
      else if (str[i-1]=='[')
      {
        answer +=  val;
        val /= 3;
        st.pop();
      }
      else//이미 answer에 더해짐 
      {
        val /=3;
        st.pop();
      }
    }
  }
  //올바른 괄호열이 아님 
  if(!st.empty()) answer = 0;
  cout<<answer<<endl;
  return 0;
}
