/**
 * @date 2024.09.28
 * @author June Park
 * 소팅 알고리즘
 * 국어 점수 높은순, 영어 점수 낮은 순, 수학점수 높은 순, 이름 증가 순
 */

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Student
{
public:
    string name;
    int kor, eng, math;

    Student(string name, int kor, int eng, int math)
    {
        this->name = name;
        this->kor = kor;
        this->eng = eng;
        this->math = math;
    }
    bool operator<(Student &student)
    {
        if (this->kor != student.kor) // 국어 높은 순
        {
            return this->kor > student.kor;
        }
        else if (this->eng != student.eng)
        { // 영어 낮은 순
            return this->eng < student.eng;
        }
        else if (this->math != student.math)
        { // 수학 높은 순
            return this->math > student.math;
        }
        else
        {
            return this->name < student.name; // 이름 alphabetical order
        }
    }
};

int N;

int main()
{
    cin >> N;
    vector<Student> students;
    for (int i = 0; i < N; i++)
    {
        string n;
        int k, e, m;
        cin >> n >> k >> e >> m;
        students.emplace_back(Student(n, k, e, m)); // 생성
    }
    sort(students.begin(), students.end()); // sort() : STL sort function
    for (const auto &student : students)
    {
        cout << student.name << "\n";
    }
}
