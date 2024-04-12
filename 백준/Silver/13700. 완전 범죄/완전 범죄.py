# 1 ~ n 건물
# startx -> s
# 범인 -> 집으로 돌아가야함
from collections import deque
from sys import stdin

N, S, D, F, B, K = map(int, stdin.readline().split(" "))
police = [False]*(N+1); police[0] = True
if K !=0:
    for x in map(int,input().split()): police[x] = True
que = deque()
que.append((S, 0))
ans =-1
while len(que) != 0:
    node = que.popleft()
    if node[0] > N or node[0] <= 0:
        continue
    if police[node[0]]:
        continue
    police[node[0]] = True
    if node[0] == D:
        ans = node[1]
        break
    que.append((node[0] + F, node[1] + 1))
    que.append((node[0] - B, node[1] + 1))
if ans == -1:
    print("BUG FOUND")
else:
    print(ans)
