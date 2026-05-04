# https://school.programmers.co.kr/learn/courses/30/lessons/134240
def solution(food):
    answer = ""
    # two way ---> water <----
    # index 만 보는거임
    for index in range(1, len(food)) :
        # 무조건 반만 담음
        half = int(food[index]/2)
        print(index, half)
        for times in range(half) :
            answer+= str(index) 
            
    reversed_str = answer[::-1]
    answer += "0"
    answer += reversed_str
    
    return answer