#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string input;
  getline(cin, input);
  for(int i = input.length()-1  ; i >=  0 ; i--)cout<<input[i];

  return 0;
}
