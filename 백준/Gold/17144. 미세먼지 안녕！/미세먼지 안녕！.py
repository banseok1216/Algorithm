import copy
import math
import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N,M,K = map(int, input().split(" "))
    board = [list(map(int, input().split(" "))) for _ in range(N)]
    firstX =-1
    firstY =-1
    secondX = -1
    secondY = -1
    for i in range(N):
        for j in range(M):
            if board[i][j] == -1 and firstX == -1:
                firstX = i
                firstY = j
            if board[i][j] == -1 and firstX != -1:
                secondX = i
                secondY = j
    list1 = [-1,1,0,0]
    list2 = [0,0,-1,1]
    for count in range(K):
        copyfirstX = firstX
        copyfirstY = firstY
        copysecondX = secondX
        copysecondY = secondY
        copyBoard = [[0 for _ in range(M)] for _ in range(N)]
        for i in range(N):
            for j in range(M):
                if board[i][j] == -1:
                    copyBoard[i][j] = -1
                    continue
                count =0
                cal = math.floor(board[i][j] / 5)
                for direct in range(4):
                    nx = i + list1[direct]
                    ny = j + list2[direct]
                    if(nx>=0 and nx<N and ny>=0 and ny<M and board[nx][ny] != -1):
                        count+=1
                        copyBoard[nx][ny] += cal
                board[i][j] -= cal * count
                copyBoard[i][j] += board[i][j]
        while(copyfirstX>0):
            copyBoard[copyfirstX][copyfirstY] = copyBoard[copyfirstX-1][copyfirstY]
            copyfirstX -= 1
        while (copysecondX < N-1):
            copyBoard[copysecondX][copyfirstY] = copyBoard[copysecondX + 1][copyfirstY]
            copysecondX += 1
        while (copyfirstY <M-1):
            copyBoard[copyfirstX][copyfirstY] = copyBoard[copyfirstX][copyfirstY+1]
            copyBoard[copysecondX][copyfirstY] = copyBoard[copysecondX][copyfirstY+1]
            copyfirstY += 1
        while (copyfirstX != firstX):
            copyBoard[copyfirstX][copyfirstY] = copyBoard[copyfirstX + 1][copyfirstY]
            copyfirstX += 1
        while (copysecondX != secondX):
            copyBoard[copysecondX][copyfirstY] = copyBoard[copysecondX - 1][copyfirstY]
            copysecondX -= 1
        while (copyfirstY >1):
            copyBoard[copyfirstX][copyfirstY] = copyBoard[copyfirstX][copyfirstY-1]
            copyBoard[copysecondX][copyfirstY] = copyBoard[copysecondX][copyfirstY-1]
            copyfirstY -= 1
        copyBoard[firstX][1] = 0
        copyBoard[secondX][1] = 0
        copyBoard[firstX][firstY] = -1
        copyBoard[secondX][secondY] = -1
        board = copy.deepcopy(copyBoard)
    ans =0
    for i in range(N):
        for j in range(M):
            if board[i][j] == -1:
                continue
            else:
                ans += board[i][j]
    print(ans)




