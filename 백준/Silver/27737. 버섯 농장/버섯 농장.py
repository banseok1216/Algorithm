# N N
# M 개의 버섯 포자 버섯이 자랄수 있는칸
# K 개의 연결된 버섯이 자랄수 있는 칸
# 한칸에 버섯 포자 여러개 가능
from collections import deque
N ,M ,K = map(int,input().split(" "))
board= [list(map(int,input().split(" "))) for _ in range(N)]
check = [[False for i in range(N)] for j in range(N)]
end = M
def bfs(x,y):
    answer = 0
    que = deque()
    que.append((x,y))
    while(len(que) != 0):
        node = que.popleft()
        if check[node[0]][node[1]]:
            continue
        check[node[0]][node[1]] = True
        answer += 1
        for i in (-1,0),(0,1),(1,0),(0,-1):
            nx = node[0] + i[0]
            ny = node[1] + i[1]
            if N>nx>=0 and N>ny>=0 and board[nx][ny] != 1:
                que.append((nx,ny))
    return answer

find = 0
for i in range(N):
    for j in range(N):
        if board[i][j] != 1 and not check[i][j]:
            find = bfs(i,j)
            M -= find//K
            if int(find%K) !=0:
                M-=1
if M>=0 and end != M :
    print("POSSIBLE")
    print(M)
else:
    print("IMPOSSIBLE")