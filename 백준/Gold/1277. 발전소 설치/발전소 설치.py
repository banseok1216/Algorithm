import heapq
import math

N, W = map(int, input().split(" "))

l = float(input())
pos = []
board = [[False for _ in range(N)] for _ in range(N)]
for _ in range(N):
    x, y = map(int, input().split(" "))
    pos.append((x, y))
for _ in range(W):
    x, y = map(int, input().split(" "))
    board[x-1][y-1] = True
    board[y-1][x-1] = True
check = [False for _ in range(N)]
pq = []
heapq.heapify(pq)
pq.append((0, 0, pos[0][0], pos[0][1]))
answer = 0
while len(pq) != 0:
    sum, num, x, y = heapq.heappop(pq)
    if num == N - 1:
        answer = sum
        break
    if check[num]:
        continue
    check[num] = True
    for i in range(N):
        new_l = math.sqrt(math.pow(x - pos[i][0], 2) + math.pow(y - pos[i][1], 2))
        if i != num:
            if board[i][num]:
                heapq.heappush(pq, (sum, i, pos[i][0], pos[i][1]))
            elif new_l <= l:
                heapq.heappush(pq, (sum + new_l, i, pos[i][0], pos[i][1]))
print(int(answer * 1000))