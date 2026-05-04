# https://school.programmers.co.kr/learn/courses/30/lessons/132267

def solution(a, b, n): # a : leer cola, b : give b, n : my bottles
    answer = 0
    if n < a : 
        return 0
    
    while (n >= a) :
        # print(f"빈 병 {n} 개 중")
        leftover = n % a
        get = (n // a) * b   # b를 곱해야 함
        give = (n // a) * a  # 가져다 준 병
 
        n = n - give + get #20 - 18 + 6
        answer += get
   
        print(f"{give} 개를 마트에 가져가서, {get} 병의 콜라를 받습니다. 이때, 상빈이가 가지고 있는 콜라 병의 수는 {n} 입니다.")

        
    return answer