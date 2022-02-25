#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> nums)
{
    vector<int> num2; //처음부터 중복을 제거
    for (int i = 0; i < nums.size(); i++)
    {
        if (i == 0)
            num2.emplace_back(nums[i]);
        else
        {
            bool dup = false; //중복 아님
            for (int j = 0; j < num2.size(); j++)
            {
                if (nums[i] == num2[j])
                {
                    dup = true;
                    break;
                }
            }
            if (!dup)
                num2.emplace_back(nums[i]);
        }
    }

    //생각해보니..unique를 제거하면.. 더이상 백트랙킹이 필요 없다.>!
    return nums.size() / 2;
    < num2.size() ? nums.size() / 2; : num2.size();
}