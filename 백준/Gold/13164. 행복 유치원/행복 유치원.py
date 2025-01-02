N, K = map(int, input().split(" "))
board = list(map(int, input().split(" ")))
sorted_board = []
for i in range(N - 1):
    sorted_board.append(board[i + 1] - board[i])
sorted_board.sort(reverse=True)
result = sum(sorted_board[K-1:])
print(result)
