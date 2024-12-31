# 1 부터 365일로 표시되는 달력
# 일정이 있는 곳에만 달력
from collections import deque

N = int(input())
board = [[] for _ in range(366)]
count = [0 for _ in range(366)]

for _ in range(N):
    a, b = map(int, input().split(" "))
    board[a].append([-(b - a + 1), b])
for i in range(len(board)):
    board[i].sort()
start = 1
for _ in range(N):
    start = 1
    for i in range(start, len(board)):
        if len(board[i]) != 0:
            length, end = board[i].pop()
            for j in range(i, end + 1):
                count[j] += 1
            start = end + 1
start = 0
answer = 0
w = 0
h = 0
while start != 366:
    if count[start] != 0:
        w += 1
        h = max(h, count[start])
    else:
        answer += w * h
        w = 0
        h = 0
    start += 1
print(answer + w * h)
