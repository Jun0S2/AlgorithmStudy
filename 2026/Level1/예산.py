# https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=python3
def solution(d,budget):
    d.sort()  # 작은 것부터 -> greedy
    answer = 0
    while(budget>0 and answer<len(d)) :
        budget -= d[answer]
        if budget <0 :
            break;
        answer += 1

    return answer

# from itertools import *
# def solution(d, budget):
#     answer = 0
#     # 이거 냅섹 문젠데..
#     # 아니면 combinations로 ?
#     all_possibilities = []
#     for x in range(1,len(d)+1):
#         pack = list(combinations(d,x)) # x 개만큼의 조합
#         skip = False
        
#         for z in pack:
#             if skip : break;
#             temp = 0
#             for y in z :
#                 temp += y
#             if temp <= budget:
#                 supported_teams = x
#                 if answer < x : # greedy. skip to next x
#                     answer = x
#                     skip = True
#     return answer