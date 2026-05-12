# https://school.programmers.co.kr/learn/courses/30/lessons/42883
def solution(number, k):
    stack = []
    
    for current in number:
        current = int(current)

        # stack not empty && prev>current -> pop prev && k left
        # top : stack[-1]
        while k > 0 and stack and stack[-1] < current:
            stack.pop() # all the conditions met
            k -= 1      # add chance
            
        # else add to stack
        stack.append(current)

    return ''.join(map(str, stack))