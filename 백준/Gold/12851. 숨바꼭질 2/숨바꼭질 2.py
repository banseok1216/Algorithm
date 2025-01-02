# 숨박꼭질
# 수빈이의 위치가 X 걷는다면 1초 후에 x-1 또는 x+1 순간이동시 2*x
from collections import deque

board = [[100000000000, 0] for i in range(100001)]

a, b = map(int, input().split(" "))

dq = deque()
dq.append((a, 0))
while dq:
    now, count = dq.popleft()
    if board[now][0] < count:
        continue
    if board[now][0] > count:
        board[now][0] = count
        board[now][1] = 1
    elif board[now][0] == count:
        board[now][0] = count
        board[now][1] += 1
    target_list = [now * 2, now + 1, now - 1]
    for nxt in target_list:
        if 0 <= nxt <= 100000:
            if board[nxt][0] >= count:
                dq.append((nxt, count + 1))
print(board[b][0])
print(board[b][1])