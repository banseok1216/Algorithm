from collections import deque
import sys
input = sys.stdin.readline

def bfs(board, N, M, list1, list2, checkBoard, i, j):
    que = deque()
    que.append((i, j))
    while que:
        node = que.popleft()
        for k in range(4):
            nx = node[0] + list1[k]
            ny = node[1] + list2[k]
            if 0 <= nx < N and 0 <= ny < M and not checkBoard[nx][ny]:
                if board[nx][ny] == 0 and board[node[0]][node[1]] > 0:
                    board[node[0]][node[1]] -= 1
                if board[nx][ny] > 0:
                    checkBoard[nx][ny] = True
                    que.append((nx, ny))
if __name__ == '__main__':
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    list1 = [-1, 1, 0, 0]
    list2 = [0, 0, -1, 1]
    times = 0

    while True:
        times += 1
        checkBoard = [[False] * M for _ in range(N)]
        count = 0
        for i in range(N):
            for j in range(M):
                if board[i][j] != 0 and not checkBoard[i][j]:
                    count += 1
                    checkBoard[i][j] = True
                    bfs(board, N, M, list1, list2, checkBoard, i, j)
        if count >= 2:
            break
        if count == 0:
            break
    print(0 if count == 0 else times - 1)
