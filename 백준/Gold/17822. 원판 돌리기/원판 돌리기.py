N, M, K = map(int, input().split(" "))
board = []
for i in range(N):
    input_list = list(map(int, input().split(" ")))
    board.append(input_list)
for i in range(K):
    x, d, k = map(int, input().split(" "))
    k %= M
    z = x
    while z - 1 < N:
        if d == 0:
            new_board = board[z - 1][-k:] + board[z - 1][:-k]
            board[z - 1] = new_board
        else:
            new_board = board[z - 1][k:] + board[z - 1][:k]
            board[z - 1] = new_board
        z += x
    check = False
    is_zero = set()
    for j in range(N):
        k = 0
        for k in range(M):
            if board[j][k] == 0:
                continue
            for dir_x, dir_y in (0, 1), (1, 0):
                if 0 <= j + dir_x <= N - 1:
                    if board[j + dir_x][(dir_y + k + M) % M] == board[j][k]:
                        is_zero.add((j, k))
                        is_zero.add((j + dir_x, (dir_y + k + M) % M))
                        check = True
    if not check:
        total = 0
        count = 0
        for j in range(N):
            for k in range(M):
                if board[j][k] != 0:
                    total += board[j][k]
                    count += 1
        for j in range(N):
            for k in range(M):
                if board[j][k] == 0:
                    continue
                elif board[j][k] > total / count:
                    board[j][k] -= 1
                elif board[j][k] < total / count:
                    board[j][k] += 1
    for x, y, in is_zero:
        board[x][y] = 0
answer = 0
for j in range(N):
    for k in range(M):
        answer += board[j][k]
print(answer)
