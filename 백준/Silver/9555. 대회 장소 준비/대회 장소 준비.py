N = int(input())
for i in range(N):
    C, R = map(int,input().split(" "))
    board = [list(map(int,input().split(" "))) for _ in range(C)]
    check = set()
    for c in range(C):
        for r in range(R):
            if board[c][r] == -1:
                continue
            if not board[c][r] in check:
                for k in (-1,0),(1,0),(0,1),(0,-1),(1,1),(1,-1),(-1,-1),(-1,1):
                    nc = c+ k[0]
                    nr = r+ k[1]
                    if C>nc>=0 and R>nr>=0 and board[nc][nr] == board[c][r]:
                        check.add(board[c][r])
    print(len(check))
