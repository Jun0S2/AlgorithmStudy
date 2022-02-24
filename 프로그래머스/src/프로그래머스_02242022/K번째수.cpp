#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<int> temp;
    for(int i = 0 ; i <commands.size() ; i++ )
    {
        int start = commands[i][0];//i
        int end = commands[i][1];//j
        int index = commands[i][2];//K
        
        for(int j = start-1 ; j < end ; j ++ )
        {
            temp.push_back(array[j]); //범위에드는 원소만
        }
        //정렬
       sort(temp.begin(), temp.end());
       answer.push_back(temp[index-1]);
       temp.clear();//초기화
    }
    return answer;
}