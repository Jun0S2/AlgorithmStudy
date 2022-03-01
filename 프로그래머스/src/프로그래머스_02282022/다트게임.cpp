#include <string>
#include <vector>

using namespace std;
// * = *2 # = *-1
//점수 보너스 옵션 -> 옵션은 없을 수도 있음
int solution(string dartResult) {
    int answer = 0;
    int index = 0;
    vector<int> scores;
    
    for(int i = 0 ; i<dartResult.size() ; i++)
    {
        //Bonus
        if(dartResult.at(i)=='S')continue;
        else if(dartResult.at(i)=='D') scores[index-1] = scores[index-1] * scores[index-1];
        else if(dartResult.at(i)=='T')scores[index-1] = scores[index-1] * scores[index-1] * scores[index-1];
        //Options
        else if (dartResult.at(i)=='*') 
        {   
            scores[index-1] = 2 * scores[index-1];
            if(index > 1) scores[index-2] = scores[index-2] *2 ;//아...
        }
         else if (dartResult.at(i)=='#') scores[index-1] = -1 * scores[index-1];
        //Numbers
        else
        {
            if(dartResult.at(i+1)=='0')  //0~10 -> 한자리 수인지 10인지 확인
            {
                scores.push_back(10);
                i++;//pointer 이동
            }
            else scores.push_back(dartResult.at(i)-'0');
            index++;
        }
    }
    //숫자 합산
    for(auto i : scores) answer += i;
    return answer;
}