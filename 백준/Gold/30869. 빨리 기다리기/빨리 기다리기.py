import heapq
import sys
from collections import deque
input = sys.stdin.readline
N, M, K = map(int, input().split())
board = [100000000 for i in range(N + 1)]
graph = [[] for i in range(N + 1)]
for i in range(M):
    input_list = list(map(int, input().split()))
    graph[input_list[0]].append(input_list[1:])
que = [[0, K, 1]]
heapq.heapify(que)

while len(que) != 0:
    time, fast, position = heapq.heappop(que)
    if position == N:
        break
    if board[position] < time:
        continue
    for end, move, wait in graph[position]:
        if time == 0:
            board[end]= move
            heapq.heappush(que, [move, fast, end])
        else:

            if wait > time:
                if board[end] > wait + move:
                    board[end] = wait + move
                    heapq.heappush(que, [wait + move, fast, end])
            if wait <= time:
                if board[end] > time % wait + time + move:
                    board[end] = time % wait + time + move
                    heapq.heappush(que, [time % wait + time + move, fast, end])
            if fast > 0 and board[end] > time + move:
                board[end]= time + move
                heapq.heappush(que, [time + move, fast - 1, end])
answer = board[N]
if answer == 100000000:
    print(-1)
else:
    print(answer)
