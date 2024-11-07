#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>
//https://school.programmers.co.kr/learn/courses/30/lessons/42579 
using namespace std;

class Music{
    public:
    int id;
    string genre;
    int playtimes;
    int total;
    
    public :
    Music(int id_, string genre_, int playtimes_, int total_) {
        this->id = id_;
        this->genre=genre_;
        this->playtimes = playtimes_;
        this->total = total_;
    }
    // customize sorting algorithm
    /** 1. per Genre play time(total) 2. per play times 3.lower id*/
    // Overload the < operator to implement custom sorting
    bool operator<(const Music& other) const {
        if (total != other.total) {             // 1. Sort by total (descending)
            return total > other.total;
        }
        if (playtimes != other.playtimes) {     // 2. Sort by playtimes (descending)
            return playtimes > other.playtimes;
        }
        return id < other.id;                   // 3. Sort by id (ascending)
    }
};

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<Music> info;
    map<string,int> cl;

    // total play times per genre
    for (int i = 0 ; i<genres.size(); i++) {
        cl[genres[i]] += plays[i];
    }
    // save all info
    for (int i = 0 ; i<genres.size(); i++) {
        info.push_back(Music{i, genres[i], plays[i], cl[genres[i]]});
    }
    sort(info.begin(), info.end());
    
    
    string selectedGenre = info[0].genre;
    answer.push_back(info[0].id);
    int selectedMusic = 1;
    
    
    for (int i = 1 ; i< info.size(); i++) {
        string currentGenre = info[i].genre;
        if(currentGenre==selectedGenre) {
            selectedMusic++;
            if(selectedMusic>2)continue;// 노노
             answer.push_back(info[i].id);
        } else {// 새 음악 넣기
            selectedMusic = 1;
            selectedGenre = currentGenre;
            answer.push_back(info[i].id);
        }
    }
    
    return answer;
}
