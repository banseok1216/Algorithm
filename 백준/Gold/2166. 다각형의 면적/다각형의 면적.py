import math

N = int(input())
board = []
a_sum = 0
b_sum = 0
first_a = 0
first_b = 0
for i in range(N):
    a, b = map(int, input().split(" "))
    if i == 0:
        first_a = a
        first_b = b
    board.append([a, b])
board.append([first_a, first_b])
answer = 0
a_sum = 0
for i in range(N):
    a_sum += board[i][0] * board[i + 1][1]
for i in range(N, 0, -1):
    b_sum += board[i][0] * board[i-1][1]
answer = 1/2 * abs(a_sum - b_sum)
print(f"{answer:.1f}")
