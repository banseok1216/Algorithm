# 크기가 N인 컨베이어 벨트 길이가 2N인 벨트

N, K = map(int, input().split(" "))
board = list(map(int, input().split(" ")))
check = [False for _ in range(N)]
level = 1
while True:
    # 이동
    board = board[-1:] + board[:-1]
    for i in range(N - 1, -1, -1):
        if check[i]:
            nxt = i + 1
            if nxt == N - 1:
                check[i] = False
            if nxt < N - 1:
                check[nxt] = True
                check[i] = False
    # 로봇 한칸 이동
    for i in range(N - 1, -1, -1):
        if check[i]:
            nxt = i + 1
            if nxt == N:
                continue
            if board[nxt] == 0:
                continue
            if nxt == N - 1:
                check[i] = False
            if nxt < N - 1:
                if check[nxt]:
                    continue
                check[nxt] = True
                check[i] = False
            board[nxt] -= 1
    if not check[0] and board[0] > 0:
        check[0] = True
        board[0] -= 1
    count = 0
    for num in board:
        if num == 0:
            count += 1
    if count >= K:
        break
    level += 1
print(level)
