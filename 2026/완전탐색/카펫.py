# https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=python3

# brown : 가로 x 2 + 세로 x 
# 10 = (4 x 2) + (3 x 2)  - 4  = 8 + 6 - 4
# 8 = (3 x 2) + (3 x 2) - 4  = 6 + 6 - 4 
# 24 = (8 x 2) + (6 x 2) - 4 = 16 + 12 - 4 = 24

# brown = (width x 2) + (height x 2) - 4
# brown + 4 = width x 2 + height x 2 + 2(w+h)
# also, brown is always even with my intuition
# (brown+4)/2 = w+h

# 2nd observation : width x height = sum(brown,yellow)

def solution(brown, yellow):
    answer = []
    sum_wh = int((brown+4)/2)
    area = brown + yellow
    print(sum_wh)
    
    # 가로 >= 세로
    # observation3 
    # BROWN = 8 이상임. 즉, height 는 3 이상임.
    for height in range(3, sum_wh+1):
        width = sum_wh - height
        if width * height == area:
            answer = [width, height]
            break;
    return answer

