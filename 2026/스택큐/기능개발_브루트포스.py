# https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=python3
import math

def solution(progresses, speeds):
    answer = []
    days = []
    works = len(speeds)
    for x in range(0, works) :
        days.append(math.ceil((100 - progresses[x]) / speeds[x]))
    
    # print(days)
    release_day = 0
    for d in range(0, works):
        # print("we are on day ", d)
        if days[d] <=0 :
            continue
            
        day_passed = days[d]
        # print(day_passed)
        released = 0
        
        for x in range(d, works):
            days[x] -= day_passed
        
        # now, works can only be relased continuously.
        for x in range(release_day,works):
            if days[x] <= 0 :
                released += 1
            else :
                break;
                
        release_day += released
        # print(released, " works were finished in one release")
        answer.append(released)
        # print(days)
        
    
    return answer