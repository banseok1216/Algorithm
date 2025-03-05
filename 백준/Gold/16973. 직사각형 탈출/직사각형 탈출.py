# 크기가 NXM 격자판에 H*W인 직사각형
from collections import deque

N, M = map(int, input().split(" "))
board = []
for _ in range(N):
    board.append(list(map(int, input().split(" "))))
H, W, sr, sc, fr, fc = map(int, input().split(" "))
s = [[1000000000000 for _ in range(M)] for _ in range(N)]
sr -= 1
sc -= 1
fr -= 1
fc -= 1

q = deque()
q.append((sr, sc, 0))
s[sr][sc] = 0
while q:
    sr, sc, p = q.popleft()
    for i in range(4):
        check = True
        if i == 0:
            for j in range(sc, sc + W):
                if sr - 1 < 0 or board[sr - 1][j] == 1:
                    check = False
        if i == 1:
            for j in range(sr, sr + H):
                if sc + W >= M or board[j][sc + W] == 1:
                    check = False
        if i == 2:
            for j in range(sc, sc + W):
                if sr + H >= N or board[sr + H][j] == 1:
                    check = False
        if i == 3:
            for j in range(sr, sr + H):
                if sc - 1 < 0 or board[j][sc - 1] == 1:
                    check = False
        if check:
            if i == 0 and s[sr - 1][sc] > p + 1:
                s[sr - 1][sc] = p + 1
                q.append((sr - 1, sc, p + 1))
            if i == 1 and s[sr][sc + 1] > p + 1:
                s[sr][sc + 1] = p + 1
                q.append((sr, sc + 1, p + 1))
            if i == 2 and s[sr + 1][sc] > p + 1:
                s[sr + 1][sc] = p + 1
                q.append((sr + 1, sc, p + 1))
            if i == 3 and s[sr][sc - 1] > p + 1:
                s[sr][sc - 1] = p + 1
                q.append((sr, sc - 1, p + 1))

if s[fr][fc] == 1000000000000:
    print(-1)
else:
    print(s[fr][fc])
