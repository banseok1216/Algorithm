N = int(input())
visited = [False for i in range(N)]
mass = [1 for i in range(N)]
board = [[] for i in range(N)]


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


for i in range(N - 1):
    a, b, p, q = map(int, input().split(" "))
    gcd_v = gcd(p, q)
    board[a].append([b, p / gcd_v, q / gcd_v])
    board[b].append([a, q / gcd_v, p / gcd_v])


def dfs(cur, mul):
    global visited
    visited[cur] = True
    count = 1
    for nxt, p, q in board[cur]:
        if not visited[nxt]:
            count *= dfs(nxt, p)
    return count * mul


root = dfs(0, 1)


def dfs_find(pre, cur, div, mul):
    global visited
    global root
    visited[cur] = True
    if pre != -1:
        mass[cur] = mass[pre] / div * mul
    for nxt, p, q in board[cur]:
        if not visited[nxt]:
            dfs_find(cur, nxt, p, q)


visited = [False for i in range(N)]
mass[0] = root
dfs_find(-1, 0, root, 1)
common = mass[0]
for j in mass:
    common = gcd(common, j)
for i in range(N):
    mass[i] = int(mass[i] / common)
answer = ""
for i in mass:
    answer += (str(int(i)) + " ")
print(answer)
