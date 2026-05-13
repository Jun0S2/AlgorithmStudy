def solution(numbers):
    # 1. 문자열로 변환
    numbers = list(map(str, numbers))
    
    # 2. 커스텀 정렬
    # 핵심: a+b와 b+a를 비교
    from functools import cmp_to_key
    def compare(a, b):
        if a + b > b + a:  # "ab"가 "ba"보다 크면
            return -1       # a를 앞에 (내림차순)
        elif a + b < b + a:
            return 1
        else:
            return 0
    
    # custom sort
    numbers.sort(key=cmp_to_key(compare))
    answer = ''.join(numbers)
    
    # 4. 엣지케이스: "000" -> "0"
    return str(int(answer))  # 또는 if answer[0] == '0': return '0'