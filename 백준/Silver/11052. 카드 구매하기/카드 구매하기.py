N = int(input())

board = [0] + list(map(int, input().split(" ")))

for i in range(1, len(board)):
    for j in range(i, len(board)):
        if i + j > N:
            continue
        board[i + j] = max(board[i] + board[j], board[i + j])
print(board[-1])