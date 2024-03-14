import collections

def bfs(x, y):
    q = collections.deque()
    q.append([x, y, 0, 0])
    visited[0][x][y] = 1
    while q:
        x, y, jump, final = q.popleft()
        if x == N - 1 and y == M - 1:
            return final
        for dx, dy in direction:
            nxt_r, nxt_c = x + dx, y + dy
            if 0 <= nxt_r <= N - 1 and 0 <= nxt_c <= M - 1:
                if A[nxt_r][nxt_c] == 0 and not visited[jump][nxt_r][nxt_c]:
                    q.append([nxt_r, nxt_c, jump, final + 1])
                    visited[jump][nxt_r][nxt_c] = 1
        for dx, dy in horse:
            nxt_r, nxt_c = x + dx, y + dy
            if 0 <= nxt_r <= N - 1 and 0 <= nxt_c <= M - 1:
                if A[nxt_r][nxt_c] == 0 and jump < K and not visited[jump + 1][nxt_r][nxt_c]:
                    q.append([nxt_r, nxt_c, jump + 1, final + 1])
                    visited[jump + 1][nxt_r][nxt_c] = 1

    return -1

K = int(input())
M, N = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
visited = [[[0] * M for _ in range(N)] for k in range(K + 1)]
direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]
horse = [[2, 1], [2, -1], [-2, 1], [-2, -1],[1,2],[1,-2],[-1,2],[-1,-2]]
print(bfs(0, 0))

