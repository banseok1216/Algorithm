from collections import deque
N, M = map(int, input().split(" "))
arr = [0 for i in range(N+1)]
board = [[] for _ in range(N+1)]
moved = [set() for _ in range(N+1)]
for i in range(M):
    up , down = map(int,input().split(" "))
    board[up].append(down)
    arr[down]+=1
que = deque()
for i in range(1,len(arr)):
    if arr[i] == 0:
        que.append((i,0))
while(len(que) != 0):
    node= que.popleft()
    for i in board[node[0]]:
        arr[i] -=1
        moved[i] |= moved[node[0]]
        moved[i].add(node[0])
        if arr[i] == 0:
            que.append((i,node[1]+1))
K = int(input())
for _ in range(K):
    a, b = map(int, input().split())
    if a in moved[b] and b not in moved[a]:
        print(-1)
    elif b in moved[a] and a not in moved[b]:
        print(1)
    else:
        print(0)
