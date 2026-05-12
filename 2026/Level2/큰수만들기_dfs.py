# https://school.programmers.co.kr/learn/courses/30/lessons/42883
# 시간초과.
def solution(number, k):
    end_index = len(number) # end
    max_num = "0"

    def dfs(index, selected_num, k_left):
        nonlocal max_num

        # Base Case - 완성
        if index == end_index:
            if k_left == 0:
                max_num = max(max_num, selected_num)
            return

        # 아직 k 번 버릴게 남아있음.
        if k_left > 0:
            dfs(index + 1, selected_num, k_left - 1)

        # else : dfs
        dfs(index + 1, selected_num + number[index], k_left)

    dfs(0, "", k)

    return max_num