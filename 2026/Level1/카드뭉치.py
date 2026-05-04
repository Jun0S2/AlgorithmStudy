# https://school.programmers.co.kr/learn/courses/30/lessons/159994
def solution(cards1, cards2, goal):
    answer = "Yes"
    # while(!goal.isempty()):
    while(goal) :
        top = goal.pop(0)
        if (cards1 and cards1[0]==top) :
            cards1.pop(0)
        elif (cards2 and cards2[0] == top) :
            cards2.pop(0)
        else:
            answer="No"        
            break;
    return answer