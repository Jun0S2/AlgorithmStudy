#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N;
vector<int> lights(N + 1, 2);

//남학생 : 자기와 받은 수의 배수이면 스위치 상태 바꿈
void Male(int n)
{
    for (int i = n; i <= N; i += n)
    {
        if (lights[i] == 0)
            lights[i] = 1;
        else
            lights[i] = 0;
    }
}

void Female(int n)
{

    lights[n] = lights[n] == 0 ? 1 : 0;

    for (int index = 1; index <= N; index++)
    {
        if (n - index == 0)
            break;
        cout << n - index << " and " << n + index << " ";
        if (lights[n - index] == lights[n + index])
        {
            lights[n - index] = lights[n - index] == 0 ? 1 : 0; // change status
            lights[n + index] = lights[n + index] == 0 ? 1 : 0; // change status
        }
        else
            break;
    }
}

// 1~8 on or off
int main()
{
    //여학생 : 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간
    cin >> N; //스위치의 개수
    lights.resize(N, 0);

    for (int i = 1; i <= N; i++)
        cin >> lights[i];

    cout << "INPUT : ";
    cout << endl;
    for (int j = 1; j <= N; j++)
        cout << lights[j] << " ";
    cout << endl;

    int M;
    cin >> M;
    int male, female;
    for (int i = 0; i < M; i++)
    {
        cin >> male >> female;
        Male(male);
        cout << "BOYDS : ";
        for (int j = 1; j <= N; j++)
            cout << lights[j] << " ";
        cout << endl;
        cout << endl;
        Female(female);
        cout << "GALS: ";
        for (int j = 1; j <= N; j++)
            cout << lights[j] << " ";
    }
    //출력 : 한줄에 20개까지 출력
}