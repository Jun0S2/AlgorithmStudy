#include <string>
#include <vector>
#include <sstream>
using namespace std;

vector<string> solution(string my_string) {
    vector<string> result;
    stringstream ss(my_string);
    string word;
    
    while (ss >> word) {  // 공백을 기준으로 단어를 하나씩 추출
        result.push_back(word);
    }
    
    return result;
}
