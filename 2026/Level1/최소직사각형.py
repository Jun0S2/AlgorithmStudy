# https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=python3   
def solution(sizes):
    answer = 0
    # 그럼 일단 가로 > 세로로 고정.
    for x in sizes:
        if x[0] < x[1] :
            temp = x[1]
            x[1] = x[0]
            x[0] = temp
    
    width=0
    height = 0
    for x in sizes :
        if x[0] > width : 
            width = x[0]
        if x[1] > height :
            height = x[1]
            
    answer = width * height
    return answer