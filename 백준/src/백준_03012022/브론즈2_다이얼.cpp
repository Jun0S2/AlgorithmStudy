#include<string>
#include<vector>
#include <iostream>

using namespace std;

int main(){
vector<int> times = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
string input;
cin>>input;
int t = 0;
for(char &c : input) t+= times[c-65];

cout<<t<<endl;
}

