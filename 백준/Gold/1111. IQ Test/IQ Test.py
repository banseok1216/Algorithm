N = int(input())
board = list(map(int, input().split(" ")))
minus = []
answer = 0
check = True
if N <= 2:
    if N == 2 and board[0] == board[1]:
        print(board[0])
    else:
        print("A")
else:
    for i in range(N - 1):
        minus.append(board[i + 1] - board[i])
    a = 0
    if 0 in minus:
        a = 0
    else:
        a = minus[1] / minus[0]
        if minus[1] % minus[0] != 0:
            check = False
    for i in range(len(minus) - 1):
        if minus[i + 1] != minus[i] * a:
            check = False
            break
    if check:
        if board[0] * a == board[1]:
            print(int(board[-1] * a))
        else:
            print(int(board[-1] * a + board[1] - board[0]* a))
    else:
        print("B")
