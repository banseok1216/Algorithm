
N = int(input())
parent = dict()
board = [[] for _ in range(N + 1)]
check = [False for _ in range(N + 1)]


def make(root):
    global parent, board, check
    stack = [root]
    check[root] = True

    while stack:
        node = stack.pop()
        for nxt in board[node]:
            if not check[nxt]: 
                parent[nxt] = node
                check[nxt] = True
                stack.append(nxt)

def find_depth(num):
    global parent
    depth = 0
    while num in parent:
        num = parent[num]
        depth += 1
    return depth


def find(num1, num2):
    global parent
    depth1 = find_depth(num1)
    depth2 = find_depth(num2)

    while depth1 > depth2:
        num1 = parent[num1]
        depth1 -= 1
    while depth2 > depth1:
        num2 = parent[num2]
        depth2 -= 1
    while num1 != num2:
        num1 = parent[num1]
        num2 = parent[num2]
    return num1


for _ in range(N - 1):
    a, b = map(int, input().split(" "))
    board[a].append(b)
    board[b].append(a)
make(1)
M = int(input())
for _ in range(M):
    a, b = map(int, input().split(" "))
    print(find(a, b))
