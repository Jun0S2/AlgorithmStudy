#include <string>
#include <vector>

using namespace std;

/*수업을 들을 수 있는 학생의 수를 세는 함수*/
int count(vector<int> arr, int n)
{
    int answer = 0;
    for (int i = 1; i <= n; ++i)
    {
        if (arr[i] >= 0)
            answer++;
    }
    return answer;
}

int solution(int n, vector<int> lost, vector<int> reserve)
{
    vector<int> uniforms(n + 2, 0); //범위때문에 앞뒤에 하나씩 더함
    for (int l : lost)
        uniforms[l]--;
    for (int r : reserve)
        uniforms[r]++;

    // uniform 이 있으면 0, 없으면 -1, 여벌이 있다면 1
    //작은 순부터 해도 될듯하다 visited없이..
    for (int i = 1; i <= n; i++)
    {
        if (uniforms[i] == 0 || uniforms[i] == 1)
            continue;
        // Else : 작은 사람한테 빌리는 것이 우선임
        if (uniforms[i - 1] == 1) //배열 0부터 시작이라 범위checkX.
        {
            uniforms[i - 1] = uniforms[i] = 0;
        }
        else if (uniforms[i + 1] == 1)
        {
            uniforms[i + 1] = uniforms[i] = 0;
        }
    }
    // print(uniforms);
    return count(uniforms, n);
}

/* Print Utility
void print(vector<int> arr){
    for(int i : arr) cout<<i<<" ";
    cout<<endl;
}
*/
