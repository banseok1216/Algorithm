import copy
from collections import deque
from itertools import combinations
N, M = map(int, input().split(" "))
board = [list(map(int,input().strip().split(" "))) for _ in range(N)]
def bfs(que,boardCopy):
    ans = 0
    while len(que) != 0:
        node = que.popleft()
        for direct in (-1,0), (0,-1),(1,0),(0,1):
            nx = direct[0] + node[0]
            ny = direct[1] + node[1]
            if nx < N and nx>= 0 and ny <N and ny >= 0:
                if boardCopy[nx][ny] != 1:
                    if boardCopy[nx][ny] == 0:
                        ans = max(ans, node[2]+1)
                    boardCopy[nx][ny] = 1
                    que.append((nx,ny,node[2] +1))
    check = True
    for i in range(N):
        for j in range(N):
            if boardCopy[i][j] != 1 and boardCopy[i][j] != 2 :
                check = False
                break
    if(check):
        return ans
    else:
        return 1000000


list1 = []
for i in range(N):
    for j in range(N):
        if board[i][j] == 2:
            list1.append([i,j,0])
perm = list(combinations(list1, M))
answer = 1000000
for list2 in perm:
    que = deque()
    boardCopy = copy.deepcopy(board)
    for list3 in list2:
        que.append(list3)
        boardCopy[list3[0]][list3[1]] = 1
    answer = min(answer,bfs(que,boardCopy))
if answer == 1000000:
    print(-1)
else:
    print(answer)
