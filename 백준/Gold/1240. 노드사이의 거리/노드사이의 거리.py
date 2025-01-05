N, M = map(int, input().split(" "))
board = [[] for _ in range(N + 1)]
check = [False for _ in range(N + 1)]

answer = 0


def dfs(num, end, count):
    global answer
    if answer != 0:
        return
    if end == num:
        answer = count
        return
    if check[num]:
        return
    check[num] = True
    for nxt in board[num]:
        dfs(nxt[0], end, count + nxt[1])


for _ in range(N - 1):
    a, b, l = map(int, input().split(" "))
    board[a].append((b, l))
    board[b].append((a, l))
find = []

for _ in range(M):
    a, b = map(int, input().split(" "))
    answer = 0
    check = [False for _ in range(N + 1)]
    dfs(a, b, 0)
    find.append(answer)
for i in range(len(find)):
    print(find[i])