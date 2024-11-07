#include <string>
#include <vector>
using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    int window = pat.size();
    for (int i = 0 ; i< myString.size();i++) {
        if(myString[i]=='A') myString[i] = 'B';
        else myString[i] = 'A';
    }
    size_t pos = myString.find(pat);
    if(pos>=0&& pos<=100) return 1;
    return answer;
}
