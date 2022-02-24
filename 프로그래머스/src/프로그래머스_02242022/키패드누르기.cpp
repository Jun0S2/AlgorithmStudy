#include <string>
#include <vector>
#include <iostream>
using namespace std;
/*
    왼쪽  : 1 4 7 *
    오른쪽  : 3 6 9 #
    가까운 : 2 5 8 0 - 거리가 같다면 본인 손잡이로
*/
string solution(vector<int> numbers, string hand) {
    string answer = "";
    int right = 10; //처음 오른손 엄지 위치 
    int left  = 11; //처음 왼손 엄지 위치
     
    vector<int> distance2 = {3,1,0,1,2,1,2,3,2,3,4,4};//키패드 2에서 다른 숫자까지(index)의 거리
    vector<int> distance5 = {2,2,1,2,1,0,1,2,1,2,3,3};
    vector<int> distance8 = {1,3,2,3,2,1,2,1,0,1,2,2};
    vector<int> distance0 = {0,4,3,4,3,2,3,2,1,2,1,1};
    
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
            int left_distance, right_distance;
            if(numbers[i]==2) //user distance2
            {
                left_distance = distance2[left];//현재 왼손의 키패드위체부터의 거리를 구함
                right_distance = distance2[right];
            }
            else if (numbers[i] == 5)
            {
                left_distance = distance5[left];
                right_distance = distance5[right];
            }
            else if (numbers[i] == 8 )
            {
                left_distance = distance8[left];//현재 왼손의 키패드위체부터의 거리를 구함
                right_distance = distance8[right];
            }
            else if (numbers[i] == 0 )
            {
                left_distance = distance0[left];//현재 왼손의 키패드위체부터의 거리를 구함
                right_distance = distance0[right];
            }
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
            else 
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