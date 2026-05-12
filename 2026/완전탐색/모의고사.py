# https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=python3
def solution(answers):
    answer = []
    scores = [0,0,0]
    
    # 일단 answers의 사이즈 만큼만 넣어도 돼지 않을까 함
    p1 = [1,2,3,4,5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for idx in range(0,len(answers)) :
        solution = answers[idx]
    	# 만약 answers 의 길이가 사람배열보다 클 경우 순환참조
        if (solution == p1[idx % len(p1)]):
            scores[0]+=1
        if (solution == p2[idx % len(p2)]):
            scores[1]+=1
        if (solution == p3[idx % len(p3)]):
        	scores[2]+=1
    
    max_score = max(scores)
    for idx in range(0,3):
        if scores[idx] == max_score:
            answer.append(idx+1)
    return answer