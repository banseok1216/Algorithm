import queue
import sys
from collections import deque

input = sys.stdin.readline


if __name__ == '__main__':
    N, M = map(int, input().split())
    mat = [list(map(int, input().split())) for _ in range(N)]
    list1 = [-1, 1, 0, 0]
    list2 = [0, 0, -1, 1]
    times = 0
    iceberg = set()
    for i in range(N):
        for j in range(M):
            if mat[i][j] != 0:
                iceberg.add((i, j))
    while True:
        times += 1
        visited = [[False] * M for _ in range(N)]
        count = 0
        copy_iceberg = iceberg.copy()
        for i, j in copy_iceberg:
                if mat[i][j] != 0 and not visited[i][j]:
                    count += 1
                    visited[i][j] = True
                    queue = deque([(i, j)])
                    while queue:
                        x, y = queue.popleft()
                        for cx, cy in (0, 1), (1, 0), (0, -1), (-1, 0):
                            nx = x + cx
                            ny = y + cy
                            if not visited[nx][ny]:
                                if mat[nx][ny] == 0 and mat[x][y] != 0:
                                    mat[x][y] -= 1
                                if mat[nx][ny] != 0:
                                    visited[nx][ny] = True
                                    queue.append((nx, ny))
                        if mat[x][y] == 0:
                            iceberg.remove((x, y))
        if count >= 2:
            break
        if count == 0:
            break
    print(0 if count == 0 else times - 1)
