#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N;
vector<int> lights(N + 1, 2);

/* 남학생 : 자기와 받은 수의 배수이면 스위치 상태 바꿈*/
void Male(int n)
{
    for (int i = n; i <= N; i += n) // 배수만 switch
    {
        lights[i] = lights[i] == 0 ? 1 : 0;
    }
}
/* 여학생 : 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간*/
void Female(int n)
{

    lights[n] = lights[n] == 0 ? 1 : 0;

    for (int index = 1; index <= N; index++)
    {
        if (n - index == 0||n + index > N)  break; //범위 out

        if (lights[n - index] == lights[n + index])//대칭이면 switch
        {
            lights[n - index] = lights[n - index] == 0 ? 1 : 0; // change status
            lights[n + index] = lights[n + index] == 0 ? 1 : 0; // change status
        }
        else break;
    }
}

int main()
{
    cin >> N; //스위치의 개수
    lights.resize(N+1, 0);//배열 리사이즈 just in case

    for (int i = 1; i <= N; i++) cin >> lights[i]; //input

    int M ,gender, num;
    cin >> M;
    
    for (int i = 0; i < M; i++)
    {
        cin >> gender >> num;
        if(gender==1) Male(num);
        else Female(num);
    }

    //출력 : 한줄에 20개까지 출력
    int cnt =  0;
    for(int j = 1; j <=N; j++)
    {
      ++cnt;
      if(cnt==20)
      {
          cout<<lights[j]<<endl;
          cnt = 0;
      }
      else cout<<lights[j]<<" ";
    }
}