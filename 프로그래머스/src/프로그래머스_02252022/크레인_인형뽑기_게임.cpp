#include <string>
#include <vector>

using namespace std;
/* peek -> same -> pop
C++에 back() 과 pop_back()이 있다 ! ( empty 체크 해줘야 core 오류 x)*/

int solution(vector<vector<int>> board, vector<int> moves)
{
    int answer = 0;
    vector<int> result;

    for (int i = 0; i < moves.size(); ++i)
    {
        int column = moves[i] - 1;             //이 column의 top을 가져올 것이다
        
        for (int j = 0; j < board.size(); j++) // row. 0부터 top임
        {
            if (board[j][column] == 0) continue;    // column 은 고정. 빈칸이면 아무일도 일어나지 않는다
            else                                    // result의 맨 뒤와 현재가 같으면 result지우기
            {
                if (!result.empty() & result.back() == board[j][column])
                {
                    answer += 2;       //터뜨려 사라진 개수(두개씩 사라짐;)
                    result.pop_back(); //이런게있다니
                }
                else result.push_back(board[j][column]); //인형 삽입
                board[j][column] = 0;                   //빈칸 처리
                // print(result);
                break; // escape
            }
        }
    }
    return answer;
}

/* 크레인 뽑기 결과 print Utility
void print(vector<int> arr)
{
    for (int i : arr)
        cout << i << " ";
    cout << endl;
}

*/
