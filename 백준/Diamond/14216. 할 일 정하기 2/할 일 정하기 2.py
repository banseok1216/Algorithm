from sys import stdin
from itertools import product

input = stdin.readline

N = int(input())
table = [list(map(int, input().split())) for _ in range(N)]


def hungarian(table):
    N = len(table)
    match_x, match_y = [None] * N, [None] * N
    label_x, label_y = list(map(max, table)), [0] * N
    is_free_x, is_free_y = (lambda x: match_x[x] == None), (lambda y: match_y[y] == None)
    gap = lambda i, j: label_x[i] + label_y[j] - table[i][j]

    while (None in match_x):
        tree_x, tree_y = [None] * N, [None] * N
        S, T = [False] * N, [False] * N

        u = next(filter(is_free_x, range(N)))
        S[u] = True
        slack, slack_x = [gap(u, j) for j in range(N)], [u] * N

        while True:
            try:
                y = next(filter(lambda j: (slack[j] == 0) and (not T[j]), range(N)))

            except:
                min_gap = min(v for v, b in zip(slack, T) if not b)
                for i in range(N):
                    label_x[i] -= min_gap * int(S[i])
                    label_y[i] += min_gap * int(T[i])
                    slack[i] -= min_gap * int(not T[i])

            else:
                if is_free_y(y):
                    tree_y[y] = slack_x[y]
                    while y != None:
                        x = tree_y[y]
                        match_y[y], match_x[x], y = x, y, match_x[x]
                    break

                else:
                    z = match_y[y]
                    tree_x[z], tree_y[y] = y, slack_x[y]
                    S[z], T[y] = True, True
                    for i in range(N):
                        slack[i], slack_x[i] = min((gap(z, i), z), (slack[i], slack_x[i]))

    return list(enumerate(match_x)), sum(label_x) + sum(label_y)


for i, j in product(range(N), repeat=2):
    table[i][j] *= -1

_, ans = hungarian(table)

print(-ans)