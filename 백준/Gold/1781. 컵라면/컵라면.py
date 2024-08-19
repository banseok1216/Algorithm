from heapq import heappop, heappush
from collections import deque

N = int(input())
board = []
answer = [0 for i in range(N + 1)]
for i in range(N):
    input_board = list(map(int, input().split(" ")))
    board.append((input_board[1], input_board[0]))
board.sort(reverse=True)
board = deque(board)
count = N
visited = [i for i in range(N + 1)]
while len(board) != 0:
    c, d = board.popleft()
    if visited[d] == 0:
        continue
    temp = visited[d]
    for z in range(temp, 0, -1):
        if visited[z] == 0:
            visited[d] = 0
            break
        if answer[z] < c:
            visited[d] = z - 1
            answer[z] = c
            break
print(sum(answer))
