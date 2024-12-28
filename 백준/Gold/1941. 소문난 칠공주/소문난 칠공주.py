# 7명의 여학생들로 구성
# 가로나 세로로 반드시 인접
# 굳이 이다솜파로 구성안하도 돼
# 그러나 이다솜파가 과반 4명 이상

# 이다솜파 S

from collections import deque
import copy


board = [[] for i in range(5)]
for i in range(5):
    board[i] = list(input())
check = set()
answer = set()
def dfs(x, y, a, back):
    global check
    a.add((x, y, board[x][y]))
    if frozenset(a) in check:
        return
    if back >=4:
        return
    check.add(frozenset(a))
    if len(a) == 7:
        answer.add(frozenset(a))
        return
    for na, nb in (-1, 0), (1, 0), (0, 1), (0, -1):
        nx = x + na
        ny = y + nb
        if 0<=nx < 5 and 0<=ny< 5 and (nx,ny,board[nx][ny]) not in a:
            if board[nx][ny] == "Y":
                back +=1
                dfs(nx,ny,copy.deepcopy(a),back)
                back -= 1
            else:
                dfs(nx, ny, copy.deepcopy(a), back)
    for ma, mb, _ in a:
        for na, nb in (-1, 0), (1, 0), (0, 1), (0, -1):
            nx = ma + na
            ny = mb + nb
            if 0 <= nx < 5 and 0 <= ny < 5 and (nx,ny,board[nx][ny]) not in a:
                if board[nx][ny] == "Y":
                    back += 1
                    dfs(nx, ny, copy.deepcopy(a), back)
                    back -= 1
                else:
                    dfs(nx, ny, copy.deepcopy(a), back)
    a.remove((x, y, board[x][y]))
    return


for i in range(5):
    for j in range(5):
        if board[i][j] == "Y":
            dfs(i, j, set(),1)
        else:
            dfs(i, j, set(), 0)
print(len(answer))