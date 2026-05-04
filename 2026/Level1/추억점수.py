# https://school.programmers.co.kr/learn/courses/30/lessons/176963
def solution(name, yearning, photo):
    answer = []
    # first, map into dictionary
    dic = dict(zip(name, yearning))
    # print(dic)
    
    for memory in photo:
        score = 0
        for person in memory:
            if person in dic :  
                score += dic[person]
        answer.append(score)
    return answer