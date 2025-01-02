N = int(input())
board = []
for _ in range(N):
    a, b = map(int, input().split(" "))
    board.append((a, b))
board.sort()
start = 0
count = 0
while start < N:
    a, b = board[start]
    while start + 1 < N and board[start + 1][0] <= b:
        b = max(b, board[start + 1][1])
        start += 1
    start += 1
    count += (b - a)
print(count)
