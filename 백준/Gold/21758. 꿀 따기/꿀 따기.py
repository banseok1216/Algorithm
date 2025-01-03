N = int(input())
board = list(map(int, input().split(" ")))
temp1 = [0 for _ in range(N)]
temp2 = [0 for _ in range(N)]
for i in range(1, N):
    temp1[i] = board[i]
    temp1[i] += temp1[i - 1]
for i in range(N - 2, -1, -1):
    temp2[i] = board[i]
    temp2[i] += temp2[i + 1]
first_max = 0
for i in range(1, N - 1):
    first_max = max(first_max, temp1[i] + temp2[i])
    first_max = max(first_max, 2 * temp1[N - 1] - temp1[i] - board[i])
    first_max = max(first_max, 2 * temp2[0] - temp2[N - i - 1] - board[N - i - 1])
print(first_max)