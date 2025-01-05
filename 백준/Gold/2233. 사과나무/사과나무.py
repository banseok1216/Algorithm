from collections import deque


def start(input_board, X, Y):
    global N, target
    stack = deque()
    board = [() for _ in range(N + 1)]
    node = 1
    depth = 1
    i = 0
    stack.append((i, node, node - 1, depth))
    while stack:
        i += 1
        if input_board[i] == 0:
            node += 1
            depth += 1
            if i == X or i == Y:
                target.append(node)
            stack.append((i, node, stack[- 1][1], depth))
        else:
            j, n, pre, d = stack.pop()
            depth -= 1
            if i == X or i == Y:
                target.append(n)
            board[n] = (pre, j, i, depth)
    return board


def find(num1, num2, board):
    depth1 = board[num1][3]
    depth2 = board[num2][3]

    while depth1 < depth2:
        num2 = board[num2][0]
        depth2 -= 1
    while depth1 > depth2:
        num1 = board[num1][0]
        depth1 -= 1
    while num1 != num2:
        num2 = board[num2][0]
        num1 = board[num1][0]
    return board[num1][1], board[num1][2]


N = int(input())
target = []
input_board = list(map(int, input()))
x, y = map(int, input().split(" "))
board = start(input_board, x - 1, y - 1)
if len(target) == 1:
    a, b = find(target[0], target[0], board)
else:
    a, b = find(target[0], target[1], board)
print(str(a + 1) + " " + str(b + 1))
