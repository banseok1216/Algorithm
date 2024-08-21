board = []
is_one = []
for i in range(10):
    _input = list(map(int, input().split(" ")))
    for j in range(10):
        if _input[j] == 1:
            is_one.append([i, j])
    board.append(_input)
is_one.sort()
N = len(is_one)
answer = 1000000000

_dic = {
    0: 5,
    1: 5,
    2: 5,
    3: 5,
    4: 5
}


def dfs(count, ans):
    global N
    global is_one
    global answer
    global _dic
    if count == N:
        answer = min(answer, ans)
        return
    if ans >= answer:
        return
    x, y, = is_one[count]
    if board[x][y] == 0:
        dfs(count + 1, ans)
    for j in range(4, -1, -1):
        if _dic[j] == 0:
            continue
        _dic[j] -= 1
        nx = x + j
        ny = y + j
        if 0 <= nx < 10 and 0 <= ny < 10:
            flag = True
            for l in range(x, nx + 1):
                for m in range(y, ny + 1):
                    if board[l][m] == 0:
                        flag = False
                        break
            if flag:
                for l in range(x, nx + 1):
                    for m in range(y, ny + 1):
                        board[l][m] = 0
                dfs(count + 1, ans + 1)
                for l in range(x, nx + 1):
                    for m in range(y, ny + 1):
                        board[l][m] = 1
        _dic[j] += 1
    return


dfs(0, 0)
if answer == 1000000000:
    print(-1)
else:
    print(answer)
