import math

N, M = map(int, input().split(" "))
board = []
check = [i for i in range(N + 1)]


def union(a, b):
    global check
    if find(a) != find(b):
        check[find(a)] = check[find(b)]


def find(a):
    global check
    if a == check[a]:
        return a
    check[a] = find(check[a])
    return check[a]


for i in range(N):
    x, y = map(int, input().split(" "))
    board.append((i + 1, x, y))
for j in range(M):
    first, second = map(int, input().split(" "))
    union(first, second)

dist = []
for i in range(N):
    for j in range(i + 1, N):
        distance = math.sqrt(pow(board[i][1] - board[j][1], 2) + pow(board[i][2] - board[j][2], 2))
        dist.append((distance, i + 1, j + 1))
answer = 0
dist.sort()
for distance, a, b in dist:
    if find(a) == find(b):
        continue
    union(a, b)
    answer += distance


print(format(answer, ".2f"))


