import copy
import queue
import sys
from collections import deque

input = sys.stdin.readline
list1 = [-1,1,0,0]
list2 = [0,0,-1,1]
ans1 =0
ans2 = 0
N =0
def bfs(bfsBoard,checkBfsBoard, x, y):
    que = queue.Queue()
    que.put((x,y))
    s = bfsBoard[x][y]
    while(not que.empty()):
        node = que.get()
        if checkBfsBoard[node[0]][node[1]]:
            continue
        checkBfsBoard[node[0]][node[1]] = True
        for k in range(4):
            nx = list1[k] +node[0]
            ny = list2[k] +node[1]
            if(nx>=0 and ny>= 0 and nx<N and ny <N):
                if(bfsBoard[nx][ny] == s):
                    que.put((nx,ny))
def bfsnot(bfsBoard,checkBfsBoard, x, y):
    que = queue.Queue()
    que.put((x,y))
    s = bfsBoard[x][y]
    while(not que.empty()):
        node = que.get()
        if checkBfsBoard[node[0]][node[1]]:
            continue
        checkBfsBoard[node[0]][node[1]] = True
        for k in range(4):
            nx = list1[k] + node[0]
            ny = list2[k] + node[1]
            if(nx>=0 and ny>= 0 and nx<N and ny <N):
                if(s == "G" or s=="R"):
                    if bfsBoard[nx][ny] == "G" or bfsBoard[nx][ny] == "R":
                        que.put((nx, ny))
                if(s == "B"):
                    if(bfsBoard[nx][ny] == "B"):
                        que.put((nx,ny))


if __name__ == '__main__':
    N = int(input())
    board = [list(map(str, input().strip()))for _ in range(N)]
    check = [[False for _ in range(N)] for _ in range(N)]
    checkNot = [[False for _ in range(N)] for _ in range(N)]
    boardNot = copy.deepcopy(board)
    for i in range(N):
        for j in range(N):
            if check[i][j] == False:
                bfs(board,check,i,j)
                ans1+=1
    for i in range(N):
        for j in range(N):
            if checkNot[i][j] == False:
                bfsnot(boardNot,checkNot,i,j)
                ans2+=1
    print(str(ans1)+" "+ str(ans2))


