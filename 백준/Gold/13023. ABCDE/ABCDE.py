# A와 B와 친구다.


N, M = map(int, input().split(" "))
board = [[] for _ in range(N)]
check = [False for _ in range(N)]

answer = 0


def dfs(start, now, count):
    global check, answer
    if answer == 1:
        return
    if count == 5:
        answer = 1
        return
    for nxt in board[now]:
        if check[nxt]:
            continue
        check[nxt] = True
        dfs(start, nxt, count + 1)
        check[nxt] = False


for i in range(M):
    a, b = map(int, input().split(" "))
    board[a].append(b)
    board[b].append(a)

for i in range(N):
    check[i] = True
    dfs(i, i, 1)
    check[i] = False
print(answer)
