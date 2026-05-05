# https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=python3
def solution(s):
    answer = ''
    elements = s.lower()
    first_letter = True
    
    for x in elements:
        if x == " ":
            first_letter = True
            answer += x
            continue
            
        if first_letter :
            first_letter = False
            if not x.isdigit() :
                answer += x.title()
                continue

        answer += x
  
        
            
    return answer