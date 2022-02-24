#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int right = 10; //처음 오른손 엄지 위치 
    int left  = 11; //처음 왼손 엄지 위치
    
    vector<vector<int>> distances = {
        {0,4,3,4,3,2,3,2,1,2,1,1}, //0
        {},//1
        {3,1,0,1,2,1,2,3,2,3,4,4},//키패드 2에서 다른 숫자까지(index)의 거리
        {},{},//3 4
        {2,2,1,2,1,0,1,2,1,2,3,3},
        {},{},//6 7
        {1,3,2,3,2,1,2,1,0,1,2,2},
        {}//9
    };
    for(int i = 0 ; i < numbers.size() ; i ++ )
    {
        //왼손인 경우
        if(numbers[i]==1|| numbers[i]==4||numbers[i]==7) 
        {
            answer += "L";
            left = numbers[i];
        }
        //오른손인 경우
        else if (numbers[i]==3||numbers[i]==6||numbers[i]==9)
        {
            answer += "R";
            right = numbers[i];
        }
        //가운데 키패드
        else 
        {
            int left_distance = distances[numbers[i]][left]; //해당 inner vector 에 접근
            int right_distance = distances[numbers[i]][right];
            //거리 계산
             if(left_distance<right_distance) 
            { 
                left = numbers[i];
                answer += "L";
            }
            else if (left_distance > right_distance ) 
            { 
                right = numbers[i];
                answer += "R";
            }
            else //거리가 같으면 사용자의 손잡이로 
            {
                if(hand=="right") { 
                    right = numbers[i];
                    answer += "R";
                }
                else 
                {
                    left = numbers[i];
                    answer += "L";
                }
            }
        }
    }
    return answer;
}