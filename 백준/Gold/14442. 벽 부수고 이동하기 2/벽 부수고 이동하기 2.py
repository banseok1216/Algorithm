import collections

def bfs(x, y):
    q = collections.deque()
    q.append([x, y, 0, 1])
    visited[0][x][y] = 1
    while q:
        x, y, crash, final = q.popleft()
        if x == N - 1 and y == M - 1:
            return final
        for dx, dy in direction:
            nxt_r, nxt_c = x + dx, y + dy
            if 0 <= nxt_r <= N - 1 and 0 <= nxt_c <= M - 1:
                if A[nxt_r][nxt_c] == 1 and crash < K and not visited[crash + 1][nxt_r][nxt_c]:
                    q.append([nxt_r, nxt_c, crash + 1, final + 1])
                    visited[crash + 1][nxt_r][nxt_c] = 1
                elif A[nxt_r][nxt_c] == 0 and not visited[crash][nxt_r][nxt_c]:
                    q.append([nxt_r, nxt_c, crash, final + 1])
                    visited[crash][nxt_r][nxt_c] = 1
    return -1


N, M, K = map(int, input().split())
A = [list(map(int, input())) for _ in range(N)]
visited = [[[0] * M for _ in range(N)] for k in range(K + 1)]
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
print(bfs(0, 0))

